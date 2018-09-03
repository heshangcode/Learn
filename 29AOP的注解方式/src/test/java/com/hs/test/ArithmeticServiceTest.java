package com.hs.test;

import com.hs.service.ArithmeticService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArithmeticServiceTest {
	private ArithmeticService arithmeticService;
	private ApplicationContext ac;

	@Before
	public void init() {
		this.ac = new ClassPathXmlApplicationContext("beans.xml");
		this.arithmeticService = this.ac.getBean("arithmeticServiceImpl", ArithmeticService.class);
	}

	@Test
	public void testAddMethod() {
		int result = this.arithmeticService.add(2,1);
		System.out.println("运行的结果："+ result);
	}
}
