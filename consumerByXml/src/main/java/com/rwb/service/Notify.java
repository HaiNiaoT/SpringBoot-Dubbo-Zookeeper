package com.rwb.service;

public interface Notify {
    void onreturn(String mes,int id);
    void onthrow(Throwable e,int id);
}
