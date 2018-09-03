package com.hs.service;

/**
 * 新增加的功能,采用静态代理
 */
public class ArithmeticServiceLogImpl implements ArithmeticService {

	//声明一个核心代码类的变量，为了后面方便调用核心代码的功能
	private ArithmeticServiceImpl asc = new ArithmeticServiceImpl();

	@Override
	public int add(int x, int y) {
		//后增加的某个功能
		System.out.println("加法传递的参数===>x="+x+",y="+y);
//		然后调用核心代码的功能
		return asc.add(2, 3);
	}

	@Override
	public int sub(int x, int y) {
		System.out.println("减法传递的参数===>x="+x+",y="+y);
		return asc.sub(2, 3);
	}

	@Override
	public int mul(int x, int y) {
		System.out.println("乘法传递的参数===>x="+x+",y="+y);
		return asc.mul(2, 3);
	}

	@Override
	public int div(int x, int y) {
		System.out.println("除法传递的参数===>x="+x+",y="+y);
		return asc.mul(2, 3);
	}
}
