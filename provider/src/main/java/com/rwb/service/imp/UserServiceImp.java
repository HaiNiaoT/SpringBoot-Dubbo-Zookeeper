package com.rwb.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.rwb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * cluster = "failfast" 集群的容错机制，应与服务的消费方相匹配，参考com.rwb.service.UserRefe
 * loadbalance = "consistenthash" 负载均衡机制设置为“一致性 Hash”，消费者请求总是发到同一个提供者。
 * */
@Service(cluster = "failfast",timeout = 50000,loadbalance = "consistenthash")
public class UserServiceImp implements UserService {
    private final static Logger log = LoggerFactory.getLogger(UserServiceImp.class);
    @Override
    public String SayHello(String name) {
        log.info("Hello {},request address {}",name, RpcContext.getContext().getRemoteAddress());
        return String.format("Hello %s,response address %s",name,RpcContext.getContext().getLocalAddress());
    }
}
