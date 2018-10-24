package com.ruirui.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ruirui.base.BaseTest;

public class BookServiceImplTest extends BaseTest{
	@Autowired
	private BookService bookService;
	
	@Test
	public void appoint() {
		System.out.println(bookService.appoint(1002, 12345678910L).toString());
	}
}
