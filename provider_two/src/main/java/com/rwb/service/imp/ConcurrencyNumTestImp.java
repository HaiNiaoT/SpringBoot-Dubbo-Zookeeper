package com.rwb.service.imp;

import com.rwb.API.ConcurrencyNumTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrencyNumTestImp implements ConcurrencyNumTest {

    private final static Logger log  = LoggerFactory.getLogger(ConcurrencyNumTestImp.class);
    @Override
    public String testNethod() {
        log.info("服务端返回的数据。。。。。");
        return "服务端返回的数据。。。。。";
    }
}
