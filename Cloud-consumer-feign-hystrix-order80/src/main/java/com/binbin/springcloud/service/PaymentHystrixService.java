package com.binbin.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The interface Payment hystrix service.
 *
 * @author binbin
 * @date 2022年06月12日 下午7:08
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentHystrixService {

    /**
     * Payment info ok string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Long id);

    /**
     * Payment info time out string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Long id);
}
