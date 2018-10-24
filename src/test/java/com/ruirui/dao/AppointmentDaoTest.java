package com.ruirui.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ruirui.base.BaseTest;
import com.ruirui.entity.Appointment;

public class AppointmentDaoTest extends BaseTest{
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Test
	public void testInsertAppointment() {
		int insertAppointment = appointmentDao.insertAppointment(1000, 001);
		System.out.println(insertAppointment);
	}
	
	@Test
	public void testQueryByKeyWithBook() {
		Appointment queryByKeyWithBook = appointmentDao.queryByKeyWithBook(1000, 001);
		System.out.println(queryByKeyWithBook.toString());
	}
}
