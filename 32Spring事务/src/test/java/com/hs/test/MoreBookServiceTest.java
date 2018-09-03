package com.hs.test;

import com.hs.service.MoreBookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MoreBookServiceTest {

	private ApplicationContext ac;
	private MoreBookService moreBookService;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		moreBookService = ac.getBean("moreBookServiceImpl", MoreBookService.class);
	}

	@Test
	public void testBuyMoreBookMethod() {
		moreBookService.buyMoreBook("wukong","1003","1001");
	}
}
