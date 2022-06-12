package com.binbin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author binbin
 * @date 2022年06月12日  下午7:06
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@EnableHystrix/**设置客户端的服务降级*/
public class OrderHystrixMain9999 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain9999.class,args);
    }
}
