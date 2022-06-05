package com.binbin.springcloud.controller;

import com.binbin.springcloud.entities.CommonResult;
import com.binbin.springcloud.entities.Payment;
import com.binbin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author binbin
 * @date 2022年06月02日  下午10:30
 */
@RestController
@Slf4j
public class PaymentController {

    private PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Value("${server.port}")
    private String port;

    /**
     * 注入服务发现客户端，可以使用此对象查询自身在注册中心注册的所有服务信息
     */
    @Resource
    private DiscoveryClient discoveryClient;
    /**
     * @author binbin
     * @date 2022/6/2 下午10:41
     * @param payment 订单信息
     * @return com.binbin.springcloud.entities.CommonResult 前后端交互对象
     * 传递给前端的交互信息
     */
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        CommonResult<Integer> commonResult = new CommonResult<>();
        Integer resultRow = paymentService.create(payment);
        log.info("插入结果"+resultRow);
        if (resultRow>0){
            return commonResult.setCode(200).setMessage("插入数据库成功,对应端口号为："+port).setData(resultRow);
        }
            return commonResult.setCode(440).setMessage(" 插入数据库失败，对应端口号为："+port).setData(null);
    }

    /**
     * @author binbin
     * @date 2022/6/2 下午11:10
     * @param id 订单号
     * @return com.binbin.springcloud.entities.CommonResult
     * 读取数据库中的指定id的订单
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable  Long id){
        CommonResult<Payment> commonResult = new CommonResult<>();
        Payment payment = paymentService.getPaymentById(id);
            if (payment!=null){
                return commonResult.setCode(200).setMessage("查询成功,对应端口号为："+port).setData(payment);
            }
        return commonResult.setCode(441).setMessage("数据库查询失败,id为"+id).setData(null);
    }

    /**
     * @author binbin
     * @date 2022/6/5 下午4:22
     * @param null
     * @return null
     *  尝试获取注册中心的所有注册信息
     */

    @GetMapping("/payment/discovery")
    public Object getDiscovery(){
        //直接获取对应的服务信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("注册的服务信息如下："+service);
        }

        //根据对外暴露的服务名称获取对应的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        //遍历所有的实例名称
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());

        }

        return this.discoveryClient;
    }
}
