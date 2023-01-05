package com.alibaba.nacos.sentinel.pojo;

import lombok.Data;

/**
 * @ClassName User
 * @Desc TODO
 * @Author Lenovo
 * @Date 2023/1/3 21:46
 * @Version 1.0
 **/
@Data
public class User {
    private String userName;

    public User(String userName){
        this.userName = userName;
    }
}
