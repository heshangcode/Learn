package com.hs.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect //标记这是切面
public class Logger {

	//在你运行方法之前执行，并且监控的是接口的执行Add方法，value可以省略
	@Before(value = "execution(int com.hs.service.ArithmeticService.add(int ,int))")
	//这句话的意思，
	//执行返回类型为int，com.hs.service.ArithmeticService接口下的add方法，传递的两个参数类型为int，int
	//简单理解为，接口里写的方法，只是少了变量值   int add(int x, int y);
	public void test01() {
		System.out.println("@Before在程序之前运行");
	}

	@Before(value = "execution(int com.hs.service.ArithmeticService.add(int ,int)) or execution(int com.hs.service.ArithmeticService.sub(int ,int))")
	public void test02() {
		System.out.println("我可以使用逻辑运算符  &&(and) ||(or)");
	}

	/**
	 * 比较推荐
	 * 在execution表达式中可以使用通配符，但是请注意任意的表达式是 ..
	 * 第一个*位置：代表返回任意的数据类型
	 * ..表示任意的意思，而不是我们之前学习的**
	 * 第二个* 监控的以Service结尾的类(接口)
	 * 第三个* 监控接口或者类下的所有的方法
	 * ..标识任意个参数类型或者参数的个数
	 */
	@Before(value = "execution(* com.hs..*Service.*(..))")
	public void test03() {
		System.out.println("我可以使用通配符");
	}

	//@Before   叫前置通知，也叫前置增强
	@Before(value = "addAndMulPointCut()")
	public void test04() {
		System.out.println("如何定义切点");
	}

	//如何定义切点(可以随意组合)
	@Pointcut(value = "execution(int com.hs.service.ArithmeticService.add(int ,int))")
	public void addPointCut() { }   //切点的名称是“addPointCut()”
	@Pointcut(value = "execution(int com.hs.service.ArithmeticService.sub(int ,int))")
	public void subPointCut() { }   //切点的名称是“subPointCut()”
	@Pointcut(value = "execution(int com.hs.service.ArithmeticService.mul(int ,int))")
	public void mulPointCut() { }   //切点的名称是“mulPointCut()”
	@Pointcut(value = "addPointCut() || mulPointCut()")
	public void addAndMulPointCut() { }


	//--------------------------------------//
	@Pointcut(value = "execution(* com.hs..service.*Service.*(..))")
	public void allMethodPointCut(){}

	//1.前置通知(增强)特点：不管程序是否正确都会执行
	@Before(value = "allMethodPointCut()")
	public void test05(JoinPoint jp) {
		System.out.println("==前置通知==");
		//获取get
		System.out.println(Arrays.asList(jp.getArgs()));
		System.out.println(jp.getSignature().getName());
		System.out.println(jp.getTarget().getClass().getName());
		System.out.println("==前置通知==");

	}

	//2.后置通知(增强)特点：不管程序是否正确都会执行
	@After(value = "allMethodPointCut()")
	public void test06(JoinPoint jp) {
		//获取get
		System.out.println("==后置增强==");
		System.out.println(Arrays.asList(jp.getArgs()));
		System.out.println(jp.getSignature().getName());
		System.out.println(jp.getTarget().getClass().getName());
		System.out.println("==后置增强==");

	}

	//3.返回通知(增强):只有程序是正确的时候才会执行，并且可以获取运行后的数据
	@AfterReturning(value = "allMethodPointCut()",returning = "hs")
	public void test07(JoinPoint jp,int hs) {
		//获取get
		System.out.println("==返回通知==");
		System.out.println("程序正常运行，正确的运行结果为==>"+hs);
		System.out.println("==返回通知==");
	}

	//4.异常通知(增强)：只有程序是错误的时候才会执行，
	@AfterThrowing(value = "allMethodPointCut()",throwing = "hs")
	public void test08(JoinPoint jp,ArithmeticException hs) {
		//获取get
		System.out.println("==异常通知==");
		System.out.println("程序运行错误==>"+hs);
		System.out.println("==异常通知==");
	}

	//5.环绕通知
	@Around("allMethodPointCut()")
	public Object test09(ProceedingJoinPoint pjp) {
		System.out.println("写某个功能，前置通知");
		Object result = null;
		try {
			result = pjp.proceed(); //执行程序返回运行的结果
			System.out.println("写某个功能，返回通知");
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			System.out.println("写某个功能，异常通知");
		}
		System.out.println("写某个功能，后置通知");
		return result;
	}
}
