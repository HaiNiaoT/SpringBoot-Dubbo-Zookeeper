package com.rwb.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class UserRefe {

    @Reference
    UserService userService;

    public String Say(String name){
        return userService.SayHello(name);
    }

}
