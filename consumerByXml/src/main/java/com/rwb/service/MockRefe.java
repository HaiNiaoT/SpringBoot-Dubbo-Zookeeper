package com.rwb.service;

import com.rwb.API.MockService;
import org.springframework.stereotype.Component;

@Component
public class MockRefe implements MockService {


    @Override
    public String mockTest() {
        return "容错数据";
    }
}
