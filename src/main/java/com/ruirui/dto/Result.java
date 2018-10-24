package com.ruirui.dto;

public class Result <T>{
	//成功的标识
	private Boolean success;
	//返回的数据
	private T data;
	//错误信息
	private String error;
	
	public Result() {
		
	}
	public Result(Boolean success,T data) {
		this.success = success;
		this.data = data;
	}
	public Result(Boolean success,String error) {
		this.success = success;
		this.error = error;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
