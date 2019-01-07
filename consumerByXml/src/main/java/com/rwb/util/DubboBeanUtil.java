package com.rwb.util;

import com.rwb.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboBeanUtil {

    private final static ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(new String[]{"dubboConfigure.xml"});

    public static  <T> T getBean(String name,Class<T> type){

       return context.getBean(name,type);
    }
}
