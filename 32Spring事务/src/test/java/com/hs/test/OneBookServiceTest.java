package com.hs.test;

import com.hs.service.OneBookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OneBookServiceTest {

	private ApplicationContext ac;
	private OneBookService oneBookService;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		oneBookService = ac.getBean("oneBookServiceImpl", OneBookService.class);
	}

	@Test
	public void testBuyOneBookTest() {
		oneBookService.buyOneBook("wukong", "1001");
	}
}
