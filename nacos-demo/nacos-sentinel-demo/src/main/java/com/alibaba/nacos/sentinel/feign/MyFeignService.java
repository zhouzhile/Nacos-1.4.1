package com.alibaba.nacos.sentinel.feign;

import com.alibaba.nacos.sentinel.feign.fallback.MyFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName MyFeignService
 * @Desc feign接口
 * @Author Lenovo
 * @Date 2023/1/6 12:25
 * @Version 1.0
 **/
@FeignClient(value = "nacos-provider-demo",path ="/provider",fallback = MyFeignServiceFallback.class)
public interface MyFeignService {

    @RequestMapping("/port")
    String getServerPort();

}
