package com.ruirui.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ruirui.base.BaseTest;
import com.ruirui.dao.BookDao;
import com.ruirui.entity.Book;
public class BookDaoTest extends BaseTest{
	@Autowired
	private BookDao bookDao;
	
	@Test
	public void testQueryById() {
		long bookId = 1000;
		Book book = bookDao.queryById(bookId);
		System.out.println(book.toString());
	}
	@Test
	public void testQueryAll() {
		List<Book> queryAll = bookDao.queryAll(0, 10);
		System.out.println(queryAll.toString());
	}
	@Test
	public void testReduceNumber() {
		long bookId = 1000;
		int reduceNumber = bookDao.reduceNumber(bookId);
		System.out.println(reduceNumber);
	}
}
