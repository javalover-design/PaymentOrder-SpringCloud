package com.binbin.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author binbin
 * @date 2022年06月06日  下午11:33
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "SpringCloud with Consul:"+port+ UUID.randomUUID().toString();
    }
}
