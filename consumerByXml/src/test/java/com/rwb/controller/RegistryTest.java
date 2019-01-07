package com.rwb.controller;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;

/**
 * 规则配置：将com.rwb.service.UserService服务降级，返回null数据
 */
public class RegistryTest {
    public static void main(String[] args) {
        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://47.99.242.112:2181"));
        registry.register(URL.valueOf("override://0.0.0.0/com.rwb.service.UserService?" +
                "category=configurators" +
                "&dynamic=false" +
                "&mock=force:return+null"));
    }
}
