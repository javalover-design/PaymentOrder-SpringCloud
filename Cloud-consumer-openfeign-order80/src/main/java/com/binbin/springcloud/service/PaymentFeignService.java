package com.binbin.springcloud.service;

import com.binbin.springcloud.entities.CommonResult;
import com.binbin.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The interface Payment feign service.
 *
 * @author binbin
 * @date 2022年06月09日 下午11:38
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") /**添加指定要访问的微服务，添加该微服务的名称*/
public interface PaymentFeignService {

    /**
     * Create int.
     *
     * @param payment the payment
     * @return the int
     */
    @PostMapping("/payment/create")
    int create(Payment payment);

    /**
     * Gets payment by id.
     *
     * @param id the id
     * @return the payment by id
     * 此处客户端调用还需要进一步的封装，将返回的信息封装成CommonResult
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

}
