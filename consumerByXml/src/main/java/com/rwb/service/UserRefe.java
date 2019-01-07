package com.rwb.service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.rwb.util.DubboBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class UserRefe {
    private final static Logger log = LoggerFactory.getLogger(UserRefe.class);

    private UserService userService;

    {
        userService = DubboBeanUtil.getBean("userService",UserService.class);
    }

    public String SayHello(String name){
        String result = userService.SayHello(name);
        log.info("返回结果 :" + result);
        return result;
    }

    public String SayBay(String name){
        RpcContext.getContext().setAttachment("index","1");
        return userService.SayBay(name);
    }

    /**
     * 回声测试，回声测试用于检测服务是否可用，所有服务自动实现 EchoService 接口，
     * 只需将任意服务引用强制转型为 EchoService，即可使用。
     *
     */
    public boolean getStatus(){
        EchoService service =  (EchoService)userService;
        String status = (String) service.$echo("OK");
         return (status.equals("OK"));
    }

    public String getAsynTask(){
        String word = userService.SayHello("BO");
        log.info("异步任务的直接调用 第一次返回 {}",word);

        if (RpcContext.getContext() != null ){
            log.info("RpcContext.getContext() is not null");
        }

        Future<String> future = RpcContext.getContext().getFuture();

        log.info("address is  {}",RpcContext.getContext().getRemoteAddress());
        try {
            word = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return word;
    }
}
