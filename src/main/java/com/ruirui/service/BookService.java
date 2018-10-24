package com.ruirui.service;

import java.util.List;


import com.ruirui.dto.AppointExecution;
import com.ruirui.entity.Book;

public interface BookService {
	// 查询一本图书
	Book getById(long bookId);
	//查询所有图书
	List<Book> getList();
	//预约图书
	AppointExecution appoint(long bookId,long studentId);
}
