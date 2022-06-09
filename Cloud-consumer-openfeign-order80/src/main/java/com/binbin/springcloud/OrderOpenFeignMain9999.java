package com.binbin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author binbin
 * @date 2022年06月09日  下午11:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderOpenFeignMain9999 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain9999.class,args);
    }
}
