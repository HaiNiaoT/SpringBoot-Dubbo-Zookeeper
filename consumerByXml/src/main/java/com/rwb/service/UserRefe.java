package com.rwb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserRefe {
    private final static Logger log = LoggerFactory.getLogger(UserRefe.class);

    private UserService userService;

    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubboConfigure.xml"});

        userService = context.getBean("userService",UserService.class);
    }

    public String SayHello(String name){
        String result = userService.SayHello(name);
        log.info("返回结果 :" + result);
        return result;
    }

    public String SayBay(String name){
        return userService.SayBay(name);
    }
}
