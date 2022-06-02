package com.binbin.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author binbin
 * @date 2022年06月02日  下午10:57
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder().title("Payment for SpringCloud").version("2.1").description("SpringCloud").build());
    }

}
