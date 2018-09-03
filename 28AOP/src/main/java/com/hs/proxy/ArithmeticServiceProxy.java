package com.hs.proxy;

import com.hs.service.ArithmeticService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 代理类
 */
public class ArithmeticServiceProxy implements InvocationHandler {

	//定义一个接口变量
	private ArithmeticService arithmeticService;

	public ArithmeticServiceProxy(ArithmeticService arithmeticService) {
		this.arithmeticService = arithmeticService;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//写了某个功能，不管程序有没有错误都执行
		System.out.println("在运行方法[" + method.getName() + "]之前执行，传递的参数为" + Arrays.asList(args));
		Object result = null;
		try {
			result = method.invoke(this.arithmeticService, args);
			//写了某个功能，只有程序没有错误才执行
			System.out.println("运行方法成功，结果为："+result);
		} catch (Exception e) {
			e.printStackTrace();
			//写了某个功能，程序有错误的时候才执行
			System.out.println("执行的方法错误");
		}
		//写了某个功能，不管程序有没有错误都执行
		System.out.println("在运行方法之后执行");
		return result;
	}
}
