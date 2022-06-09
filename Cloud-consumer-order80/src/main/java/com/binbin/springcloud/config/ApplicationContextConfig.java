package com.binbin.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author binbin
 * @date 2022年06月03日  上午12:36
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //添加负载均衡机制 ，当需要自己实现负载均衡的时候需要去掉负载均衡接口
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
