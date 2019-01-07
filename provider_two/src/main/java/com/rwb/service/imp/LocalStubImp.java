package com.rwb.service.imp;

import com.rwb.API.LocalStub;

public class LocalStubImp implements LocalStub {
    @Override
    public String stub(String name) {
        return "Lcoal Stub Tset  : " + name ;
    }
}
