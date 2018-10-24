package com.ruirui.exception;
/**
 * 重复预约的异常
 *
 */
public class RepeatAppointException extends RuntimeException{
	public RepeatAppointException(String message) {
		super(message);
	}
	public RepeatAppointException(String message,Throwable cause) {
		super(message,cause);
	}
}
