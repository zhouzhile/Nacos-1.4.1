package com.alibaba.nacos.config.contro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigController
 * @Desc TODO
 * @Author Lenovo
 * @Date 2022/8/18 10:43
 * @Version 1.0
 **/
@RestController
@RefreshScope
@RequestMapping("config")
public class ConfigController {

    @Value("${user.name}")
    private String userName;

    @GetMapping("/name")
    public String getUserName() {
        return userName;
    }
}
