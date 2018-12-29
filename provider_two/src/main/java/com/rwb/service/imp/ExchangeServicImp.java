package com.rwb.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.rwb.service.ExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportResource;

@Service(version = "1.1.0")
@ImportResource(locations = {"classpath=application.properties"})
public class ExchangeServicImp implements ExchangeService {

    private static final Logger log = LoggerFactory.getLogger(ExchangeServicImp.class);

    @Override
    public String Word(String name) {
        log.info("request address {}", RpcContext.getContext().getRemoteAddress());
        return String.format("%s : Hello,Response %s, version %s",name,RpcContext.getContext().getLocalAddress(),"1.1.0");
    }
}
