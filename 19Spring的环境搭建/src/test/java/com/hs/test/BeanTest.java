package com.hs.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

/**
 * Bean的生命周期测试
 */
public class BeanTest {
	/**
	 * 获取HashMap对象
	 */
	@Test
	public void test01() {
//		1.读取核心配置文件 == 发现了Bean标签就会对class对应的类进行实例化操作
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		2.获取对象(两种方式)----map1就是beans.xml id的名字
		HashMap hsmap1 = (HashMap) ac.getBean("map1");
		System.out.println(hsmap1);

		HashMap hsmap2 = ac.getBean("map1",HashMap.class);
		System.out.println(hsmap2);
	}
}
