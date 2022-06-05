package com.binbin.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author binbin
 * @date 2022年06月05日  下午5:01
 */
@RestController
@Slf4j
public class PaymentController {
    /**测试是否能够获取到端口号，能否成功注册进zookeeper*/
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zk")
    public String paymentZookeeper(){
        return "SpringCloud with zookeeper"+port+"\t"+ UUID.randomUUID().toString();

    }

}
