package com.alibaba.nacos.sentinel.contro;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Desc TODO
 * @Author Lenovo
 * @Date 2023/1/5 21:40
 * @Version 1.0
 **/
@RestController
@RequestMapping(("/user"))
public class UserController {

    @RequestMapping("/getMessage")
    @SentinelResource(value = "/getMessage",blockHandler = "blockHandlerGetMessage")
    public String getMessage(){
        return "正常调用";
    }

    public String blockHandlerGetMessage(BlockException blockException){
        return "流控啦！！！";
    }



}
