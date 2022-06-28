package com.binbin.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author binbin
 * @date 2022年06月28日  下午1:29
 */
@Component
@Slf4j
public class MyLogGlobalFilter implements GlobalFilter, Ordered {


    /**
     * @author binbin
     * @date 2022/6/28 下午1:32
     * @param exchange HTTP请求-响应交互的契约,提供对请求和响应的访问
     * @param chain 网关过滤链条
     * @return reactor.core.publisher.Mono<java.lang.Void> 
     *     表示过滤的方法
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***********come in  MyLogGlobalFilter "+new Date());
        //通过exchange获取请求的参数
        //首先利用exchange对象获取对应的请求参数的第一个字段（后续的字段仍旧需要判断）
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname==null){
            //此处如果uname为空，则表示请求中没有携带uname参数
            log.info("***************用户名为null，非法用户");

            //如果没有匹配成功，则需要给予相应的响应，并设置相应的状态码
             exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //响应设置完成
             return exchange.getResponse().setComplete();
        }
        //对过滤链条进行放行，后面的方法继续判断是否匹配（此时表示合法用户）
        return chain.filter(exchange);
    }

    /**
     * @author binbin
     * @date 2022/6/28 下午1:32 
     * @return int 
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
