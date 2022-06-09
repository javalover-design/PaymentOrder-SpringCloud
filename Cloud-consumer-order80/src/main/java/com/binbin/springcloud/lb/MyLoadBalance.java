package com.binbin.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author binbin
 * @date 2022年06月09日  下午8:56
 */
@Component
public class MyLoadBalance implements LoadBalance {

    /***
     定义一个原子计数器，用来记录RestTemplate调用的次数,初始值为0
     */
    private AtomicInteger atomicInteger=new AtomicInteger(0);


    /**
     * @author binbin
     * @date 2022/6/9 下午9:00
     * @return int
     * 得到之后进行自增
     */
    private Integer getAndIncrement(){
        Integer current;
        Integer next;
        do {
            //获取当前的原子对象值
            current=this.atomicInteger.get();
            //next进行自增
            next=current>=2147483647?0:current++;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("访问次数："+next);
        return next;
    }

    /**
     * @author binbin
     * @date 2022/6/9 下午9:10
     * @param serviceInstances 已有的微服务数量
     * @return org.springframework.cloud.client.ServiceInstance  返回可用的微服务实例
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //调用次数与服务数量取余数得到下一个访问可用服务的下标
        Integer indexAvailable=getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(indexAvailable);
    }

}
