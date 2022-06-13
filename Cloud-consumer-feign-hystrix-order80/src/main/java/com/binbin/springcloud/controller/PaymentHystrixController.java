package com.binbin.springcloud.controller;

import com.binbin.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binbin
 * @date 2022年06月12日  下午7:12
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class PaymentHystrixController {

    private PaymentHystrixService paymentHystrixService;

    @Autowired
    public PaymentHystrixController( PaymentHystrixService paymentHystrixService) {
        this.paymentHystrixService = paymentHystrixService;
    }

    /**
     * @author binbin
     * @date 2022/6/12 下午7:15
     * @param id
     * @return java.lang.String 返回调用的结果
     */
    @HystrixCommand
    @GetMapping("/consumer/hystrix/ok/{id}")
   public  String paymentInfoOk(@PathVariable("id") Long id){

        String result=paymentHystrixService.paymentInfoOk(id);
        log.info("***********result:"+result);
        return result;
    }

    /**
     * @author binbin
     * @date 2022/6/12 下午7:16
     * @param id
     * @return java.lang.String 返回调用的结果
     */
    //@HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="1500")
    //})
    @HystrixCommand
    @GetMapping("/consumer/hystrix/timeout/{id}")
     public String paymentInfoTimeOut(@PathVariable("id") Long id){
        String result=paymentHystrixService.paymentInfoTimeOut(id);
        log.info("*********result:"+result);
        return result;
    }

    /**
     * @author binbin
     * @date 2022/6/12 下午8:10
     * @param id
     * @return java.lang.String
     * 服务降级调用方法
     */
    public String paymentInfoTimeOutHandler(@PathVariable("id") Long id){
        return "我是消费者80,这里出了一点情况，请你稍后再调用，给您造成的不便请你谅解。";
    }


    /**
     * @author binbin
     * @date 2022/6/13 下午7:02
     * @return java.lang.String
     * 统一的服务降级提示信息(全局提示信息)
     */
    public String paymentGlobalFallbackMethod(){
        return "Global异常处理信息，请稍后再试";
    }
}
