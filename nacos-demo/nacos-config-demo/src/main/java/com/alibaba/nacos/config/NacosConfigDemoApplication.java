package com.alibaba.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigDemoApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigDemoApplication.class, args);
        // 服务启动时，将将配置文件中配置的内容解析到Spring的Eventment中。我们在这里获取
        while (true){ // 看我们改了配置，能否实时的感知到变化
            String userName = applicationContext.getEnvironment().getProperty("user.name");
            String userAge = applicationContext.getEnvironment().getProperty("user.age");
            String config = applicationContext.getEnvironment().getProperty("user.config");
            System.err.println("user name :" + userName + "; age: " + userAge + "; config: " +config);
            TimeUnit.SECONDS.sleep(1);
        }

    }

}
