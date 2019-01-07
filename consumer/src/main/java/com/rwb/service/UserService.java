package com.rwb.service;


/**
 * 消费方调用服务提供方的服务时，应提供与服务的提供方提供相同签名的
 * 接口并且包所在路径一致
 */

public interface UserService {

    String SayHello(String name);

    String SayBay(String name);
}
