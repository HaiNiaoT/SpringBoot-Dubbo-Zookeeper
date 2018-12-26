package com.rwb.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.rwb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImp implements UserService {
    private final static Logger log = LoggerFactory.getLogger(UserServiceImp.class);
    @Override
    public String SayHello(String name) {
        log.info("Hello {},request address {}",name, RpcContext.getContext().getRemoteAddress());
        return String.format("Hello %s,response address %s",name,RpcContext.getContext().getLocalAddress());
    }
}
