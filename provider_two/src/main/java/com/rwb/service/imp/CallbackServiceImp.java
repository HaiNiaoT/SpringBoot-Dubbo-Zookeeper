package com.rwb.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.rwb.API.CallbackListener;
import com.rwb.API.CallbackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CallbackServiceImp implements CallbackService {

    private final Map<String,CallbackListener> listeners = new ConcurrentHashMap<>();

    public CallbackServiceImp(){

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        for (Map.Entry<String,CallbackListener> entry : listeners.entrySet()){
                            try {
                                entry.getValue().changed(getChanged(entry.getKey()));
                            }catch (Throwable e){
                                listeners.remove(entry.getKey());
                            }
                        }
                        Thread.sleep(5000);
                    }catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }


    @Override
    public void addListener(String key, CallbackListener listener) {
        listeners.put(key,listener);
        listener.changed(getChanged(key));
    }

    private String getChanged(String key){
        return "Changed : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
