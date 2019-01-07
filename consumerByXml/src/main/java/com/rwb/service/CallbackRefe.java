package com.rwb.service;

import com.rwb.API.CallbackListener;
import com.rwb.API.CallbackService;
import com.rwb.util.DubboBeanUtil;
import org.springframework.stereotype.Service;

@Service
public class CallbackRefe {

    private CallbackService callbackService;

    {
        callbackService = DubboBeanUtil.getBean("callbackService",CallbackService.class);
    }

    /**
     * 参数回调
     */
    public void callbackTest(){
        callbackService.addListener("RenWen", new CallbackListener() {
            @Override
            public void changed(String msg) {
                System.out.println("callback1 : "+ msg);
            }
        });

    }
}
