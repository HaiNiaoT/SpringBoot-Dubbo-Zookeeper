package com.rwb.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.rwb.API.MockService;

@Service
public class MockServiceImp implements MockService {
    @Override
    public String mockTest() {
        return "本地伪装 服务端"+ RpcContext.getContext().getLocalAddress()+"返回数据.......";
    }
}
