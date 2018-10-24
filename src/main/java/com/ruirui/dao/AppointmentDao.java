package com.ruirui.dao;

import org.apache.ibatis.annotations.Param;

import com.ruirui.entity.Appointment;

public interface AppointmentDao {
	/**
	 * 添加预约图书数量
	 */
	int insertAppointment(@Param("bookId") long bookId,@Param("studentId") long studentId);
	/**
	 * 通过主键查询预约图书记录，并携带图书实体
	 */
	Appointment queryByKeyWithBook(@Param("bookId") long bookId,@Param("studentId") long studentId);
}
