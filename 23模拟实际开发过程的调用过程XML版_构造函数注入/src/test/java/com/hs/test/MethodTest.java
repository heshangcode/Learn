package com.hs.test;

import com.hs.web.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodTest {

	@Test
	public void test01() {
		//	1.读取配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		UserController userController = applicationContext.getBean("userController", UserController.class);
		userController.add();
	}

}
