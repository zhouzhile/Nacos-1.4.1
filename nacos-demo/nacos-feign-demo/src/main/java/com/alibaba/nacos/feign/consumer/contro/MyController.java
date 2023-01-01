package com.alibaba.nacos.feign.consumer.contro;

import com.alibaba.nacos.feign.consumer.feign.MyFeignService;
import com.alibaba.nacos.feign.consumer.feign.MyFeignService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MyController
 * @Desc 通过访问本Controller，调用远程服务
 * @Author Lenovo
 * @Date 2023/1/1 10:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("provider")
public class MyController {

    @Autowired
    MyFeignService myFeignService;

    @Autowired
    MyFeignService2 myFeignService2;

    @GetMapping("/port")
    public String getPort(){

        String serverPort = myFeignService.getServerPort();
        String serverPort1 = myFeignService2.getServerPort();

        return "Feign接口"+serverPort+serverPort1;
    }
}
