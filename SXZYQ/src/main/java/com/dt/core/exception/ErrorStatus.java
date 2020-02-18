package com.dt.core.exception;

public enum ErrorStatus {
	/**
	 * 不合法的参数
	 */
	BAD_PARAM(1001, "不合法的参数"),
	/**
	 * 超出时间范围
	 */
	TIME_ERROR(1002, "超出时间范围"),
	/**
	 * 暂无相关信息
	 */
	UNKOWN(1010, "调用失败"),
	/**
	 * 需要登录
	 */
	NEED_LOGIN(1009, "需要登录"),
	EXIST_ERROR(1003, "用户名已存在"),
	USER_ERROR(1004, "用户名或密码错误"),
	NOEXIST_ERROR(1005, "用户名不存在"),
	PHONE_EXIST_ERROR(1006, "手机号码已存在"),
	NOAUTH_ERROR(1007, "没有权限"),
	TASK_RUN(1008, "还有正在进行的任务"),
	TASK_EXIST(1011, "任务名称重复");
	private final int code;
	private final String message;

	ErrorStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
