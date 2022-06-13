package com.binbin.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.binbin.springcloud.dao.PaymentDao;
import com.binbin.springcloud.entities.Payment;
import com.binbin.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //--------服务降级
    /**
     * @author binbin
     * @date 2022/6/12 下午7:43
     * @param id
     * @return java.lang.String
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
            //此处表示设置正常的超时时间为3秒钟，如果超过3秒，则会报错
    })
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




    /**
     * @author binbin
     * @date 2022/6/12 下午7:46
     * @param id
     * @return java.lang.String
     * 服务超时处理的兜底方法
     */
    public String paymentInfoTimeOutHandler(Long id){
        return  "线程池： "+Thread.currentThread().getName()+"PaymentInfoTimeOutHandler,id："+id+"\t"+"8001出现了问题！！！！！！！！真的很抱歉，我们不能提供服务了。";

    }

    //-------------服务降级

    //--------------服务熔断
/**
 * @author binbin
 * @date 2022/6/13 下午7:49
 * @param id
 * @return java.lang.String
 * 进行服务熔断操作
 */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率到达value时候跳闸
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        if (id<0){
            throw new RuntimeException("id不能够为负数");

        }
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t调用成功，流水号为："+serialNumber;
    }


    public String paymentCircuitBreakerFallBack(@PathVariable("id")Long id){
        return "id不能够为负数，请稍后再试，进行了熔断服务";
    }
    //---------------服务熔断

}
