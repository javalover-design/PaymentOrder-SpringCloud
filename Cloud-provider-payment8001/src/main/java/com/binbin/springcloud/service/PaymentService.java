package com.binbin.springcloud.service;

import com.binbin.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author binbin
 * @date 2022年06月02日  下午1:34
 */
public interface PaymentService {
    /**用于插入支付信息
     * @author binbin
     * @date 2022/6/2 下午1:35
     * @param payment 支付信息
     * @return int 返回影响行数
     *
     */
   int create(Payment payment);

    /**
     * Gets payment by id.
     *
     * @param id id值
     * @return com.binbin.springcloud.entities.Payment payment by id
     * @author binbin
     * @date 2022 /6/2 上午12:30
     */
    Payment getPaymentById(@Param("id") Long id);


}
