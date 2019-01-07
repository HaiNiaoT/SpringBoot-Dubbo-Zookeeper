package com.rwb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:dubboConfigure.xml"})
public class ConsumerByXml {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerByXml.class,args);
    }
}
