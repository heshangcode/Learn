package com.hs.web;

import com.hs.service.UserService;

public class UserController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void add() {
		System.out.println("UserController层--->ADD");
		this.userService.add();
	}

}
