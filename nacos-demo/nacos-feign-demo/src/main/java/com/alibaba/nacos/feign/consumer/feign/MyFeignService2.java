package com.alibaba.nacos.feign.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName MyFeignService
 * @Desc feign接口，调用远程的接口
 * @Author Lenovo
 * @Date 2023/1/1 10:11
 * @Version 1.0
 **/
@FeignClient(value = "nacos-provider2-demo",path ="/provider2")
public interface MyFeignService2 {

    @GetMapping("/port")
    String getServerPort();
}
