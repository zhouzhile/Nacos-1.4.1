package com.alibaba.nacos.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName SentinelService
 * @Desc TODO
 * @Author Lenovo
 * @Date 2023/1/5 21:29
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients
public class SentinelDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelDemoApplication.class, args);
    }

}
