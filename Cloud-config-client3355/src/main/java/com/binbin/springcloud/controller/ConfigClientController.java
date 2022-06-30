package com.binbin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binbin
 * @date 2022年07月01日  上午12:12
 */
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configinfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
