package com.alibaba.nacos.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName FeifnDemoService
 * @Desc TODO
 * @Author Lenovo
 * @Date 2023/1/1 10:14
 * @Version 1.0
 **/
@EnableFeignClients
@SpringBootApplication
public class FeifnDemoService {

    public static void main(String[] args) {
        SpringApplication.run(FeifnDemoService.class,args);
    }
}
