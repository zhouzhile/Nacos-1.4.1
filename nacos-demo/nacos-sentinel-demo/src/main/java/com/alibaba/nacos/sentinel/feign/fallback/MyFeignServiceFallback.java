package com.alibaba.nacos.sentinel.feign.fallback;

import com.alibaba.nacos.sentinel.feign.MyFeignService;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyFeignServiceFallback
 * @Desc TODO
 * @Author Lenovo
 * @Date 2023/1/6 14:32
 * @Version 1.0
 **/
@Component
public class MyFeignServiceFallback implements MyFeignService {
    @Override
    public String getServerPort() {
        return "fallback方法";
    }
}
