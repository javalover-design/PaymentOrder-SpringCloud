package com.binbin.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * The interface Load balance.
 *
 * @author binbin
 * @date 2022年06月09日 下午8:50
 */
public interface LoadBalance {
    /**
     * Instances service instance.
     *
     * @param serviceInstances the service instances
     * @return the service instance
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
