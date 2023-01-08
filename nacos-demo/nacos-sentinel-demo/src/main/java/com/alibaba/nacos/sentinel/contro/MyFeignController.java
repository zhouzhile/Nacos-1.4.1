package com.alibaba.nacos.sentinel.contro;

import com.alibaba.nacos.sentinel.feign.MyFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MyFeignController
 * @Desc TODO
 * @Author Lenovo
 * @Date 2023/1/6 14:07
 * @Version 1.0
 **/
@RestController
@RequestMapping("/feign")
public class MyFeignController {

    @Autowired
    MyFeignService myFeignService;

    @RequestMapping("/port")
    public String getPort(){
        return myFeignService.getServerPort();
    }

}
