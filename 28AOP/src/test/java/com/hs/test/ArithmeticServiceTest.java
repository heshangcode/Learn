package com.hs.test;

import com.hs.proxy.ArithmeticServiceProxy;
import com.hs.service.ArithmeticService;
import com.hs.service.ArithmeticServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class ArithmeticServiceTest {

	private ArithmeticService arithmeticService;

	@Before //再每个单元测试运行之前都要进行这个方法
	public void init() {
		this.arithmeticService = new ArithmeticServiceImpl();//new ArithmeticServiceLogImpl();    //想用哪个功能就实例化哪个
	}

	/**
	 * 静态代理
	 */
	@Test
	public void testAddMethod() {
		int result = this.arithmeticService.add(2, 3);
		System.out.println(result);
	}

	/**
	 * 动态代理
	 */
	@Test
	public void test01() {
		//实例化代理类
		ArithmeticServiceProxy asp = new ArithmeticServiceProxy(this.arithmeticService);
//      固定写法
		ArithmeticService as = (ArithmeticService) Proxy.newProxyInstance(ArithmeticServiceImpl.class.getClassLoader(), ArithmeticServiceImpl.class.getInterfaces(), asp);

		int result = as.div(10, 1);
		System.out.println(result);
	}
}
