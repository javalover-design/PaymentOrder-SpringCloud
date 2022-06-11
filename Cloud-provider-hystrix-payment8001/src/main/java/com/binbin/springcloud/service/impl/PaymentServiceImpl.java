package com.binbin.springcloud.service.impl;

import com.binbin.springcloud.dao.PaymentDao;
import com.binbin.springcloud.entities.Payment;
import com.binbin.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author binbin
 * @date 2022年06月02日  下午1:37
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    /**
     * @author binbin
     * @date 2022/6/2 下午1:37
     * @param payment
     * @return int
     */
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * @author binbin
     * @date 2022/6/2 下午1:38
    * @param id
    * @return com.binbin.springcloud.entities.Payment
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    /**
     * @author binbin
     * @date 2022/6/11 下午8:47
     * @param id
     * @return java.lang.String
     */
    @Override
    public String paymentInfoOk(Long id) {
        return "线程池： "+Thread.currentThread().getName()+"PaymentInfoOK,id："+id+"\t"+"正确！！！！！！！！";
    }

    @Override
    public String paymentInfoTimeOut(Long id) {
        int timeOut=3;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
           throw new RuntimeException("超时了.....");
        }
        return  "线程池： "+Thread.currentThread().getName()+"PaymentInfoTimeOut,id："+id+"\t"+"正确，但是发生超时！！！！！！！！超时了"+timeOut+"秒钟";
    }
}
