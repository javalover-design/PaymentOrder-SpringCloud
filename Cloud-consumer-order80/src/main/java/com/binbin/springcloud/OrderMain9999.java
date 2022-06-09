package com.binbin.springcloud;

import com.binbin.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author binbin
 * @date 2022年06月03日  上午12:29
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class) //定义轮询的服务名以及对应的轮询规则类
public class OrderMain9999 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain9999.class,args);
    }
}
