package com.rwb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource(locations = {"classpath:dubbo.xml"})
@ImportResource(value = {"classpath:dubbo.xml"})
public class ProviderTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderTwoApplication.class,args);
    }
}
