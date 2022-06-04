package com.binbin.springcloud.dao;

import com.binbin.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * The interface Payment dao.
 *
 * @author binbin
 * @date 2022年06月02日 上午12:27
 */
@Mapper
public interface PaymentDao {

    /**
     * Create int.
     *
     * @param payment 支付对象
     * @return int 返回受影响的行数
     * @author binbin
     * @date 2022 /6/2 上午12:29
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
