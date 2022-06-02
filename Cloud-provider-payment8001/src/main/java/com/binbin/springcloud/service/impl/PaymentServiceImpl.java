package com.binbin.springcloud.service.impl;

import com.binbin.springcloud.entities.Payment;
import com.binbin.springcloud.service.PaymentService;

/**
 * @author binbin
 * @date 2022年06月02日  下午1:37
 */
public class PaymentServiceImpl implements PaymentService {
    /**
     * @author binbin
     * @date 2022/6/2 下午1:37
     * @param payment
     * @return int
     */
    @Override
    public int create(Payment payment) {
        return 0;
    }

    /**
     * @author binbin
     * @date 2022/6/2 下午1:38
 * @param id
 * @return com.binbin.springcloud.entities.Payment
     */
    @Override
    public Payment getPaymentById(Long id) {
        return null;
    }
}
