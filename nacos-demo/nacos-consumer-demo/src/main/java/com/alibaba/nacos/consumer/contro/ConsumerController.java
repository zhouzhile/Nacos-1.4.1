package com.alibaba.nacos.consumer.contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerController
 * @Desc TODO
 * @Author Lenovo
 * @Date 2022/8/18 10:09
 * @Version 1.0
 **/
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/port")
    public String getServerPort() {
        String msg = restTemplate.getForObject("http://nacos-provider-demo/provider/port", String.class);
        return msg;
    }

}
