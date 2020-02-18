package com.dt.response;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


/**
 * Created by administrator on ${date}
 */
public class Result {
	private boolean success = true;
	private int code = 1000;
	private String message = "操作成功";
	private String error = "调用成功";
	private Map<String, Object> data = new HashMap<String, Object>();

	public static Result create() {
		return new Result();
	}

	public Result add(Map<String, Object> map) {
		this.data.putAll(map);
		return this;
	}
	public Result fail(){
		return this.fail(null, null);
	}
	
	public Result fail(String message){
		return this.fail(null, message);
	}
	
	public Result fail(String error, String message){
		this.success=false;
		this.code=1010;
		if(StringUtils.isNotBlank(error)){
			this.error=error;
		}
		if(StringUtils.isNotBlank(message)){
			this.message=message;
		}
		return this;
	}
	public Result fail(String error, Integer code,String message){
		this.success=false;
		if(code!=null) {
		   this.code=code;
		}else {
		  this.code=1010;
		}
		
		if(StringUtils.isNotBlank(error)){
			this.error=error;
		}else {
			this.error="调用失败";
		}
		if(StringUtils.isNotBlank(message)){
			this.message=message;
		}else {
			this.message="操作失败";
		}
		return this;
	}

	public Result addMapString(Map<String, String> map) {
		this.data.putAll(map);
		return this;
	}

	public Result add(String key, Object value) {
		data.put(key, value);
		return this;
	}

	public boolean isSuccess() {
		return success;
	}

	public Result setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Result(){}
	public Result( boolean success ,int code , String message , String error ){
		this.code=code;
		this.success=success;
		this.message=message;
		this.error=error;
	}

	public  static Result SUCCESS(int code,String message){
		return new Result(true,code,message,null);
	}
}
