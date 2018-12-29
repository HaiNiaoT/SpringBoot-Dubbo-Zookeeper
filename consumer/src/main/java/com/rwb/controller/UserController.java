package com.rwb.controller;

import com.rwb.service.UserRefe;
import com.rwb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRefe userRefe;

    @GetMapping("say")
    public String Say(){
        String info = userRefe.Say("Ren");
        log.info(info);

        return info;
    }

    @GetMapping("word")
    public String Word(){
        String info = userRefe.Word("Wen");
        log.info(info);
        return info;
    }
}
