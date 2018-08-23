package com.hs.test;

import com.hs.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 对象的比较
 */
public class ObjectTest {
	/**
	 * 同一个类的实例化对象比较
	 */
	@Test
	public void test01() {
//		1.读取核心配置文件 == 发现了Bean标签就会对class对应的类进行实例化操作
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		u1就是bean标签里的id的名字
		User user1 = ac.getBean("u1", User.class);
		User user2 = ac.getBean("u2", User.class);
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user1==user2);   //false
		System.out.println(user1.equals(user2));    //false
	}

	/**
	 * Bean的范围说明——默认为单例模式
	 */
	@Test
	public void test02() {
//		1.读取核心配置文件 == 发现了Bean标签就会对class对应的类进行实例化操作
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user1 = ac.getBean("u1", User.class);
		User user2 = ac.getBean("u1", User.class);
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user1==user2);   //true
		System.out.println(user1.equals(user2));    //true
	}

	/**
	 * Bean的范围说明——设置多例模式
	 */
	@Test
	public void test03() {
//		1.读取核心配置文件 == 发现了Bean标签就会对class对应的类进行实例化操作
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		User user1 = ac.getBean("u2", User.class);
		User user2 = ac.getBean("u2", User.class);
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user1==user2);   //false
		System.out.println(user1.equals(user2));    //false
	}
}
