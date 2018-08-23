package com.hs.test;

import com.hs.model.User;
import org.junit.Test;

/**
 * 对象的初始化数据操作
 */
public class InitObject {
	/**
	 * 构造函数—初始化数据
	 */
	@Test
	public void test01() {
		User u1 = new User();
		/*这一句话设计到的知识点：
		new 开辟一块堆内存空间
		User(); 构造函数
				1.创建对象
				2.对数据进行初始化操作
		u1: 在栈内存中定义了一个变量指向了堆内存空间
		* */
		/*构造函数知识点：
		1.默认有一个无参构造函数
		2.若写了一个有参构造函数，覆盖了默认的无参，直接new User()报错
		3.第2点解决办法就是，再写一次无参构造函数
		4.每个构造函数默认一个super(),不写也有，并且得在首行
		* */
		System.out.println(u1.getUser_name());  //初始化的数据为空
	}

	/**
	 * setter方法初始化数据，其实如果属性不private，可以直接对象的变量.属性赋值
	 */
	@Test
	public void test02() {
		User u1 = new User();
		u1.setUser_id(200);
		u1.setUser_name("八戒");
	}

	/**
	 * 知识点：数组的数据初始化操作有几种？
	 * 各个类型的初始值是什么
	 */
	@Test
	public void test03() {
		//动态初始化
		int[] arr = new int[3];
		//char[] arr = new char[3];
		System.out.println(arr[2]);
		//静态初始化
		boolean[] arr2 = {false, true, true};   //下面的那种简写
		boolean[] arr3 = new boolean[]{false, true, true};
	}
}
