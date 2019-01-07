package com.rwb.service.imp;

import com.alibaba.dubbo.rpc.RpcContext;
import com.rwb.API.AcceptsNumTset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcceptsNumTestImp implements AcceptsNumTset {

    private final static Logger log = LoggerFactory.getLogger(AcceptsNumTestImp.class);

    @Override
    public String acceptTestMethod() {

        log.info("{来自 {} 的请求}", RpcContext.getContext().getRemoteAddress());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        return "服务端，连接控制测试。。。。。。";
    }
}
