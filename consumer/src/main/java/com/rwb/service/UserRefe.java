package com.rwb.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class UserRefe {
    /**
     * 调用抽象服务时，应与抽象服务处在同一级包下
     */
    @Reference(retries = 2,cluster="failfast",loadbalance = "consistenthash")
    UserService userService;

    @Reference(version = "1.1.0")
    ExchangeService exchangeService;

    public String Say(String name){
        return userService.SayHello(name);
    }

    public String Word(String name){
        return exchangeService.Word(name);
    }

}
