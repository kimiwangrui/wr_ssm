package com.ruirui.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruirui.entity.Book;

public interface BookDao {
	/**
	 * 通过id查询图书
	 */
	Book queryById(long id);
	
	/**
	 * 查询所有图书
	 */
	List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	
	/**
	 * 减少图书的数量
	 */
	int reduceNumber(long bookId);
}
