package com.hs.web;

import com.hs.service.UserService;
import com.hs.service.impl.UserServiceImpl;

public class UserController {

	private UserService userService = new UserServiceImpl();

	public void add() {
		System.out.println("UserController层--->ADD");
		this.userService.add();
	}

}
