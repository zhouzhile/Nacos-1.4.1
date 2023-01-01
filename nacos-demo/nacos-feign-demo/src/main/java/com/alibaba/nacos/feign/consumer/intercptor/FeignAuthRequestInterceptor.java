package com.alibaba.nacos.feign.consumer.intercptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName FeignAuthRequestInterceptor
 * @Desc 自定义拦截器
 * @Author Lenovo
 * @Date 2023/1/1 14:45
 * @Version 1.0
 **/
public class FeignAuthRequestInterceptor implements RequestInterceptor {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 在这里做一些统一的业务处理
        logger.info("自定义拦截器");
    }
}
