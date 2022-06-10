package com.binbin.springcloud.controller;

import com.binbin.springcloud.entities.CommonResult;
import com.binbin.springcloud.entities.Payment;
import com.binbin.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binbin
 * @date 2022年06月09日  下午11:45
 */
@RestController
@Slf4j
public class OrderOpenFeignController {

    /**注入添加了OpenFeign注解的微服务调用接口对象*/
    private final PaymentFeignService paymentFeignService;

    @Autowired
    public OrderOpenFeignController(PaymentFeignService paymentFeignService) {
        this.paymentFeignService = paymentFeignService;
    }

    /**
     * @author binbin
     * @date 2022/6/9 下午11:50
     * @param id
     * @return com.binbin.springcloud.entities.CommonResult<com.binbin.springcloud.entities.Payment>
     *     通过paymentFeignService对象调用本模块的方法，之后利用FeignClient注解去指定微服务名称的项目上
     *     寻找指定的方法调用
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentByIdForOpenFeign(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);

    }

    /**
     * @author binbin
     * @date 2022/6/10 下午1:11
     * @return java.lang.String
     * 返回端口号，测试超时
     */
    @GetMapping("/consumer/payment/port")
    public String getPaymentPort(){
        return paymentFeignService.getPaymentPort();
    }
}
