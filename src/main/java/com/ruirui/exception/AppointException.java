package com.ruirui.exception;
/**
 * 预约的异常
 *
 */
public class AppointException extends RuntimeException{
	public AppointException(String message) {
		super(message);
	}
	public AppointException(String message,Throwable cause) {
		super(message,cause);
	}
}
