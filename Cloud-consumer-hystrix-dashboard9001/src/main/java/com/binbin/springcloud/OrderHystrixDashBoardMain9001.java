package com.binbin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author binbin
 * @date 2022年06月13日  下午8:37
 */
@SpringBootApplication
@EnableHystrixDashboard
public class OrderHystrixDashBoardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixDashBoardMain9001.class,args);
    }
}
