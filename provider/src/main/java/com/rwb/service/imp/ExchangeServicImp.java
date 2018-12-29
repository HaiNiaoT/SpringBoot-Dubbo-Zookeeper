package com.rwb.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.rwb.service.ExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * version = "1.0.0" 配置版本，消费者也需要配置 例：com.rwb.service.UserRefe
 */
@Service(version = "1.0.0")
public class ExchangeServicImp implements ExchangeService {

    private static final Logger log = LoggerFactory.getLogger(ExchangeServicImp.class);

    @Override
    public String Word(String name) {
        log.info("request address {}", RpcContext.getContext().getRemoteAddress());
        return String.format("%s : Hello,Response %s",name,RpcContext.getContext().getLocalAddress());
    }
}
