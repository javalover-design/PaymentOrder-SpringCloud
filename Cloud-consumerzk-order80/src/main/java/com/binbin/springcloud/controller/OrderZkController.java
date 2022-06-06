package com.binbin.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author binbin
 * @date 2022年06月05日  下午7:58
 */
@RestController
@Slf4j
public class OrderZkController {
    /**定义远程调用地址*/
    private static final String INVOKE_URL="http://cloud-provider-payment";

    private RestTemplate restTemplate;
    @Autowired
    public OrderZkController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/payment/zk")
    public String getPaymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return  result;
    }
}
