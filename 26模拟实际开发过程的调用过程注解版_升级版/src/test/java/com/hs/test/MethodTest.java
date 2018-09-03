package com.hs.test;

import com.hs.web.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodTest {
	@Test
	public void test01() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		UserController controller = applicationContext.getBean("userController", UserController.class);
		controller.add();
	}
}
