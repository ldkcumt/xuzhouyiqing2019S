package com.dt.core.encrypt;

public interface RedisKey {
	String TOKEN ="TK_"; //根据客户端传递的token获取登录信息和RC4KEY
	String CONTEND_QUESTION = "CQ_"; //抢答
	String UID_2_TOKEN="U2TK_";//每个登录者（UID）最新的token和客户端类型
	String UID_TOKEN_SPLITCHAR ="@@_@@";
}
