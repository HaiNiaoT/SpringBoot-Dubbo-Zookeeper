package com.rwb.controller;

import com.alibaba.dubbo.rpc.RpcContext;
import com.rwb.API.AcceptsNumTset;
import com.rwb.API.ConcurrencyNumTest;
import com.rwb.API.MockService;
import com.rwb.service.*;
import com.rwb.util.ConcurrencyTest;
import com.rwb.util.DubboBeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRefe userRefe;

    @Autowired
    private CallbackRefe callbackRefe;

    @Autowired
    private NotifyRefe notifyRefe;


    @GetMapping("/sayHello")
    public String SayHello(){
        return userRefe.SayHello("RenForXml");
    }

    @GetMapping("/sayBay")
    public String SayBay(){
        return userRefe.SayBay("WenForXml");
    }

    @GetMapping("echoTest")
    public boolean EchoTest(){
        return userRefe.getStatus();
    }

    @GetMapping("/attachment")
    public String Attachment(){
        return RpcContext.getContext().getAttachment("key");
    }

    @GetMapping("/getAsync")
    public String getAsync(){
        return userRefe.getAsynTask();
    }

    @GetMapping("/callbackTest")
    public String callbackTest(){
        callbackRefe.callbackTest();
        return "SUCCESS";
    }

    /**
     * 实现事件通知 在调用之前、调用之后、出现异常时，会触发 oninvoke、onreturn、onthrow 三个事件
     * @return
     */
    @GetMapping("/notifyTest")
    public String notifyTest(){
        try {
            notifyRefe.notifyTest();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    @GetMapping("/localstubTset")
    public String localStubTest(){
        LocalRefe localRefe = DubboBeanUtil.getBean("localRefe",LocalRefe.class);
        return localRefe.stub("...");
    }

    /**
     * 本地伪装，当我使用MockService的实现类时MockRefe会出现类型无法转化的报酬
     *
     */
    @GetMapping("/mockTest")
    public String mockTset(){
        MockService mockRefe = DubboBeanUtil.getBean("mockTsetService", MockService.class);
        return mockRefe.mockTest();
    }

    @GetMapping("/executesTest")
    public String executesTest(){
        ConcurrencyTest.ConcurrencyMethod();
        return "SUCCESS";
    }

    @GetMapping("/accpetsNum")
    public String accpetsNum (){
        ConcurrencyTest.ConcurrencyMethodCon();
        return "SUCCESS";
    }
}
