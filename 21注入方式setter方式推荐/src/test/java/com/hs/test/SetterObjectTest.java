package com.hs.test;

import com.hs.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * setter方法初始化数据
 */
public class SetterObjectTest {

	/**
	 * 测试
	 */
	@Test
	public void test01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user = ac.getBean("user01",User.class);
		System.out.println(user);
		user.getHsTest().print();
	}

}
