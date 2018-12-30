package com.rwb.util;

import com.alibaba.dubbo.rpc.cluster.Merger;
import org.springframework.stereotype.Component;

@Component
public class UserMerger implements Merger<String> {
    @Override
    public String merge(String... items) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("这是合并返回的结果 : ");
        for (int i = 0; i < items.length; i++) {
            stringBuffer.append(items[i]).append("|");
        }
        return stringBuffer.toString();
    }
}
