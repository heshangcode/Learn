package com.hs.service;

/**
 * 核心代码
 */
public class ArithmeticServiceImpl implements ArithmeticService {
	@Override
	public int add(int x, int y) {
		//核心代码
		int result = x + y;
		return result;
	}

	@Override
	public int sub(int x, int y) {
		int result = x - y;
		return result;
	}

	@Override
	public int mul(int x, int y) {
		int result = x * y;
		return result;
	}

	@Override
	public int div(int x, int y) {
		int result = x / y;
		return result;
	}
}
