package com.hs.test;

import com.hs.web.UserController;
import org.junit.Test;

public class MethodTest {
	/**
	 * 测试传统调用过程
	 */
	@Test
	public void test01() {
		UserController userController = new UserController();
		userController.add();
	}

}
