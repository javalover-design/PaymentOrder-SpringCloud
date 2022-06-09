package com.binbin.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author binbin
 * @date 2022年06月08日  下午11:43
 * 自定义轮询规则
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getIRule(){
        //定义为随机
        return new RandomRule();
    }
}
