package com.alibaba.nacos.sentinel.contro;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.nacos.sentinel.pojo.User;
import com.alibaba.nacos.sentinel.rules.SentinelRules;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SentinelContro
 * @Desc TODO
 * @Author Lenovo
 * @Date 2023/1/3 21:36
 * @Version 1.0
 **/
@RestController
@RequestMapping("sentinel")
public class SentinelContro {

    private static final String RESOURCE_NAME = "getName";

    @RequestMapping("/getName")
    @SentinelResource(value = RESOURCE_NAME,
        blockHandler = "blockHandlerForGetUser",
        fallback = "fallbackForGetUser"
//        exceptionsToIgnore = {ArithmeticException.class}
    )
    public User getUserName(String id){
        int a = 1/0;
        return new User("my name is zhou");
    }

    /**
     * 注意：
     *  1. 一定要public
     *  2. 返回值一定要和源方法保证一致， 包含源方法的参数。
     *  3. 可以在参数最后添加BlockException 可以区分是什么规则的处理方法
     * @param id
     * @param ex
     * @return
     */
    public User blockHandlerForGetUser(String id, BlockException ex) {
        ex.printStackTrace();
        return new User("流控！！");
    }

    /**
     * 注意：
     *  1. 一定要public
     *  2. 返回值一定要和源方法保证一致， 包含源方法的参数。
     *  3. 可以在参数最后添加BlockException 可以区分是什么规则的处理方法
     * @param id
     * @param throwable
     * @return
     */
    public User fallbackForGetUser(String id, Throwable throwable) {
        throwable.printStackTrace();
        return new User("异常处理");
    }
}
