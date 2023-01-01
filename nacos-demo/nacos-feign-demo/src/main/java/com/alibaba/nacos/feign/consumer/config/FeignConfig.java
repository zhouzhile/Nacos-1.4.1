package com.alibaba.nacos.feign.consumer.config;

import com.alibaba.nacos.feign.consumer.intercptor.FeignAuthRequestInterceptor;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfig
 * @Desc TODO
 * @Author Lenovo
 * @Date 2023/1/1 10:37
 * @Version 1.0
 **/
@Configuration // 如果使用@Configuration注解，那么在通过feign调用其他接口时都会打印日志
public class FeignConfig {

    /**
     * Feign日志级别
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * 超时时间
     *
     * @return
     */
    @Bean
    public Request.Options options(){
        return new Request.Options(5000,10000);
    }

    /**
     * 将自定义的拦截器注册为Bean
     *
     * @return
     */
    @Bean
    public FeignAuthRequestInterceptor feignAuthRequestInterceptor(){
        return new FeignAuthRequestInterceptor();
    }
}
