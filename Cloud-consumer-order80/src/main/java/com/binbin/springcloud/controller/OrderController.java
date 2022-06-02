package com.binbin.springcloud.controller;

import com.binbin.springcloud.entities.CommonResult;
import com.binbin.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author binbin
 * @date 2022年06月03日  上午12:32
 */
@RestController
@Slf4j
@CrossOrigin
public class OrderController {
    private static final String PAYMENT_URL="http://localhost:8001";

    private RestTemplate restTemplate;

    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * @author binbin
     * @date 2022/6/3 上午12:45
     * @param payment 订单信息
     * @return com.binbin.springcloud.entities.CommonResult<com.binbin.springcloud.entities.Payment>
     *  远端调用服务提供者的方法，创建payment对象
     */
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
   return  restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

    }


    /**
     * @author binbin
     * @date 2022/6/3 上午12:50
     * @param id 订单信息
     * @return com.binbin.springcloud.entities.CommonResult<com.binbin.springcloud.entities.Payment>
     *  远程调用服务提供者的方法，通过id获取对象
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
