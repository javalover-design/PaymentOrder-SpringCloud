package com.binbin.springcloud.controller;

import com.binbin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author binbin
 * @date 2022年06月11日  下午8:55
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    /**
     * @author binbin
     * @date 2022/6/11 下午9:23
     * @param id 
     * @return java.lang.String 
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Long id){
        String result= paymentService.paymentInfoOk(id);
        log.info("**********result="+result);
        return result;
    }

    /**
     * @author binbin
     * @date 2022/6/11 下午9:25
     * @param id 
     * @return java.lang.String 
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Long id){
            String result=paymentService.paymentInfoTimeOut(id);
            log.info("***********result="+result);
            return result;
    }



}
