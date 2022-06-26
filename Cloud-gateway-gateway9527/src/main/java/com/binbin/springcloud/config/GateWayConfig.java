package com.binbin.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author binbin
 * @date 2022年06月26日  下午8:34
 */
@Configuration
public class GateWayConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        //获取所有的路由对象
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //id类似于yml文件中的名称
        /**
         * 配置了一个id为news_China的路由规则，
         * 当访问http://localhost:9527/guonei的时候，会自动转发到地址：http://news.baidu.com/guonei
         * 国际新闻同理
         * */
     return    routes.route("news_China",r->r.path("/guonei").uri("https://news.baidu.com/guonei")).
                route("news_World",r->r.path("/guoji").uri("https://news.baidu.com/guoji")).build();

    }
}
