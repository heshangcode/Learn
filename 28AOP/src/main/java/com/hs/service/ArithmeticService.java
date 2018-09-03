package com.hs.service;

/**
 * 对外提供的核心业务，完成了加法/减法/乘法/除法运算
 */
public interface ArithmeticService {
	int add(int x, int y);

	int sub(int x, int y);

	int mul(int x, int y);

	int div(int x, int y);
}
