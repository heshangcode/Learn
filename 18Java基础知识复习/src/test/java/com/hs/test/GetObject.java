package com.hs.test;

import com.hs.model.User;
import org.junit.Test;

/**
 * 获取对象并且进行比较
 */
public class GetObject {
	/**
	 * 考查知识点，对象每次都可以是新的
	 */
	@Test
	public void test01() {
		User u1 = this.getUser();
		User u2 = this.getUser();
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u1 == u2);   //结果是false
		System.out.println(u1.equals(u2));  //结果是false
		//百度==和equals比较的是什么？是内存地址，如果对象(都是继承了object(里面有equals方法))里重写equals，又是什么结果，
	}

	public User getUser() {
		//new 一次，就产生一个新的对象(内存地址不一样)，两个对象都是不一样的，都是新的
		return new User();
	}

	/**
	 * 考查知识点，对象每次都可以是一样的、同一个实例
	 */
	@Test
	public void test02() {
		User u1 = this.getUser02();
		User u2 = this.getUser02();
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u1 == u2);   //结果是true
		System.out.println(u1.equals(u2));  //结果是true
		//百度==和equals比较的是什么？是内存地址，如果对象(都是继承了object(里面有equals方法))里重写equals，又是什么结果，
		u1.setUser_name("悟空");

		System.out.println(u2.getUser_name());  //输出悟空，为什么会这样？设计到一个叫引用传递的

	}

	private static User u1 = new User();    //设计模式-单例的设计 饿汉(不管你用不用，我都先创建好),加了一个static，表示这是一个共享数据

	public User getUser02() {
		return this.u1;
	}

	//懒汉(你用我才创建)---线程不安全
	/*private static User u2;

	public User getUser002() {
		if (u2 == null) {
			u2 = new User();
		}
		return this.u2;
	}*/
}
