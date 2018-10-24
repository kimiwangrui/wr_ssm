package com.ruirui.dto;

import com.ruirui.entity.Appointment;
import com.ruirui.enums.AppointStateEnum;

public class AppointExecution {
	//图书的id
	private long bookId;
	//预约的标识
	private int state;
	//预约的状态
	private String stateInfo;
	//预约成功的对象
	private Appointment appointment;
	
	
	public AppointExecution() {
		
	}
	public AppointExecution(long bookId,AppointStateEnum appointStateEnum) {
		this.bookId = bookId;
		this.state = appointStateEnum.getState();
		this.stateInfo = appointStateEnum.getStateInfo();
	}
	public AppointExecution(long bookId,AppointStateEnum appointStateEnum,Appointment appointment) {
		this.bookId = bookId;
		this.state = appointStateEnum.getState();
		this.stateInfo = appointStateEnum.getStateInfo();
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "AppointExecution [bookId=" + bookId + ", state=" + state + ", stateInfo=" + stateInfo + ", appointment="
				+ appointment + "]";
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	
	
}
