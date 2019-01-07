package com.rwb.service;

import com.rwb.API.LocalStub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 本地存根
 */
public class LocalRefe implements LocalStub {

    private final static Logger log = LoggerFactory.getLogger(LocalRefe.class);

    private LocalStub localStub;

    public LocalRefe(LocalStub localStub){
        this.localStub = localStub;
    }

    @Override
    public String stub(String name) {
        try{
            return localStub.stub(name);
        }catch (Exception e){
            log.info("这是客户端返回数据，服务端调用失败");
            return "ERROR";
        }
    }
}
