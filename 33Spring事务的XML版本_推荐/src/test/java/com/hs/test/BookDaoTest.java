package com.hs.test;

import com.hs.dao.BookDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookDaoTest {

	private ApplicationContext ac;
	private BookDao bookDao;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		bookDao = ac.getBean("bookDaoImpl", BookDao.class);
	}

	@Test
	public void testGetBookPriceByIsbnMethod() {
		System.out.println(bookDao.getBookPriceByIsbn("1002"));
	}

	@Test
	public void testUpdateUserBalanceMethod() {
		bookDao.updateUserBalance("tangseng", 10);
	}

	@Test
	public void testUpdateBookStockMethod() {
		bookDao.updateBookStock("1003");
	}
}
