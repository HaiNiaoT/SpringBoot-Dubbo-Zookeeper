package com.rwb.service;


import com.rwb.API.IDemoService;
import com.rwb.service.imp.NotifyImp;
import com.rwb.util.DubboBeanUtil;
import org.junit.Assert;
import org.springframework.stereotype.Service;

@Service
public class NotifyRefe {

    public void notifyTest() throws InterruptedException {
        NotifyImp notify = DubboBeanUtil.getBean("demoCallback",NotifyImp.class);
        IDemoService demoService = DubboBeanUtil.getBean("demoService", IDemoService.class);

        int requestId = 2;
        String meg = demoService.get(requestId);

        Assert.assertEquals(null,meg);

        for (int i=0;i<10;i++){
            if (!notify.ret.containsKey(requestId)){
                Thread.sleep(200);
            }else{
                break;
            }
        }
        System.out.println("ref value " + notify.ret.get(requestId));
    }
}
