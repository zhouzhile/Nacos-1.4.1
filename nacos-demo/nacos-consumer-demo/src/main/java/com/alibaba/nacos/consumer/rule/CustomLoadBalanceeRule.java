package com.alibaba.nacos.consumer.rule;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName CustomLoadBalanceeRule
 * @Desc 自定义负载均衡策略，实现基于Nacos权重的负载均衡策略
 * @Author Lenovo
 * @Date 2022/12/31 15:41
 * @Version 1.0
 **/
public class CustomLoadBalanceeRule extends AbstractLoadBalancerRule {

    @Autowired
    NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public Server choose(Object key) {
        DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer)getLoadBalancer();
        String serviceName = loadBalancer.getName();
        System.out.println("服务名:"+serviceName);
        // 获取命名空间，在配置文件中哪个服务使用本规则，就获取这个服务的命名空间
        NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
        // nacos基于权重的算法
        try {
            // 根据服务名从nameService中获取到服务实例
            Instance instance = namingService.selectOneHealthyInstance(serviceName);
            return new NacosServer(instance);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

}
