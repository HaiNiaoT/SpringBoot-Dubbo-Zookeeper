package com.rwb.service.imp;

import com.rwb.API.IDemoService;

/**
 * 实现事件通知 在调用之前、调用之后、出现异常时，会触发 oninvoke、onreturn、onthrow 三个事件
 */
public class DemoServiceImp implements IDemoService {
    @Override
    public String get(int id) {
        return "id : " + id;
    }
}
