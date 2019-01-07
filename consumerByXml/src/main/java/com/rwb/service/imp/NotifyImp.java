package com.rwb.service.imp;

import com.rwb.service.Notify;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotifyImp implements Notify {

    public Map<Integer,String> ret = new ConcurrentHashMap<>();
    public Map<Integer,Throwable> errors = new ConcurrentHashMap<>();

    @Override
    public void onreturn(String mes, int id) {
        System.out.println("onreturn : " + mes);
        ret.put(id,mes);
    }

    @Override
    public void onthrow(Throwable e, int id) {
        errors.put(id,e);
    }
}
