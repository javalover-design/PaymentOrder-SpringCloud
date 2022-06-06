package com.binbin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author binbin
 * @date 2022年06月07日  上午12:50
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderConsulMain9999 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain9999.class,args);
    }
}
