package com.hs.test;

import com.hs.model.User;
import org.junit.Test;

/**
 * 对象的创建方式
 */
public class CreateObject {
	/**
	 * 使用new关键字实例化对象
	 */
	@Test
	public void test01() {
		User u = new User();
		System.out.println(u);
	}

	/**
	 * 使用Class_forName实例化对象
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@Test
	public void test02() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		User u = (User) Class.forName("com.hs.model.User").newInstance();   //com.hs.model.User为类的全路径，newInstance()实例化对象
		System.out.println(u);
		u.setUser_name("悟空");
		System.out.println(u.getUser_name());
	}

}
