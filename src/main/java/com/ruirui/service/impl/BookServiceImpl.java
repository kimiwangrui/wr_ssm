package com.ruirui.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruirui.dao.AppointmentDao;
import com.ruirui.dao.BookDao;
import com.ruirui.dto.AppointExecution;
import com.ruirui.entity.Appointment;
import com.ruirui.entity.Book;
import com.ruirui.enums.AppointStateEnum;
import com.ruirui.exception.AppointException;
import com.ruirui.exception.NoNumberException;
import com.ruirui.exception.RepeatAppointException;
import com.ruirui.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookDao bookDao; 
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public Book getById(long bookId) {
		return bookDao.queryById(bookId);
	}

	@Override
	public List<Book> getList() {
		return bookDao.queryAll(0, 1000);
	}

	@Override
	@Transactional
	public AppointExecution appoint(long bookId, long studentId) {
		try {
			int stockNum = bookDao.reduceNumber(bookId);
			if(stockNum <= 0) {
				throw new NoNumberException("该图书已没有库存");
			}else {
				int insert = appointmentDao.insertAppointment(bookId, studentId);
				if(insert <= 0) {
					throw new RepeatAppointException("此图书已预约过。");
				}else {
					Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
					return new AppointExecution(bookId,AppointStateEnum.SUCCESS,appointment);
				}
			}
		} catch (NoNumberException e1) {
			throw e1;
		} catch (RepeatAppointException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new AppointException("预约异常"+e.getMessage());
		}
	}

}
