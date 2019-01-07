package com.rwb.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.rwb.service.UserService;

//@Service(group = "rwb1")
public class UserServiceImo1 implements UserService {
    @Override
    public String SayHello(String name) {
        return "Hello "+ name;
    }

    @Override
    public String SayBay(String name) {
        return "Bay " + name;
    }
}
