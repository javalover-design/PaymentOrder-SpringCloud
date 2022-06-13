package com.binbin.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author binbin
 * @date 2022年06月13日  下午7:16
 * 编写该类实现服务重写方法，这些方法可以用作降级处理，用于统一管理服务接口中的方法回调。
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Long id) {
        return "----------来自：PaymentFallbackService和paymentInfoOk--------,这是一个服务降级方法";
    }

    @Override
    public String paymentInfoTimeOut(Long id) {
        return "----------来自：PaymentFallbackService和paymentInfoTimeOut--------,这是一个服务降级方法";
    }
}
