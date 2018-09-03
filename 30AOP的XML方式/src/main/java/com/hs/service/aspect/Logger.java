package com.hs.service.aspect;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

//@Component
//@Aspect //标记这是切面
public class Logger {

	public void test01() {
		System.out.println("测试出order属性的作用");
	}

	//1.前置通知
	public void test05(JoinPoint jp) {
		//获取get
		System.out.println("==前置通知==");
		System.out.println(Arrays.asList(jp.getArgs()));
		System.out.println(jp.getSignature().getName());
		System.out.println(jp.getTarget().getClass().getName());
		System.out.println("==前置通知==");
	}

	//2.后置通知
	public void test06(JoinPoint jp) {
		System.out.println("==后置增强==");
		System.out.println(Arrays.asList(jp.getArgs()));
		System.out.println(jp.getSignature().getName());
		System.out.println(jp.getTarget().getClass().getName());
		System.out.println("==后置增强==");

	}
	//3.返回通知
	public void test07(JoinPoint jp, int hs) {
		System.out.println("==返回通知==");
		System.out.println("程序正常运行，正确的运行结果为==>" + hs);
		System.out.println("==返回通知==");
	}
	//4.异常通知
	public void test08(JoinPoint jp, ArithmeticException hs) {
		System.out.println("==异常通知==");
		System.out.println("程序运行错误==>" + hs);
		System.out.println("==异常通知==");
	}

}
