package com.alibaba.nacos.provider.contro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Desc TODO
 * @Author Lenovo
 * @Date 2022/8/18 9:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("provider2")
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/port")
    public String getServerPort() {
        return "Nacos Provider2 port:" + serverPort;
    }
}
