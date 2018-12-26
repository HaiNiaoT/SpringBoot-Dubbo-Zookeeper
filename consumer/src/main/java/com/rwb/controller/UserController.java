package com.rwb.controller;

import com.rwb.service.UserRefe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRefe userRefe;

    @GetMapping("say")
    public String Say(){
        return userRefe.Say("Ren");
    }
}
