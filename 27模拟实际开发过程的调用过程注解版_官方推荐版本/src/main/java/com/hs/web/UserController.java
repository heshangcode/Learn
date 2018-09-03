package com.hs.web;

import com.hs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Component  //相当于<bean id="userController" class="com.hs.web.UserController"/>
@Controller //跟上面意思一样，只是为了知名见意
public class UserController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void add() {
		System.out.println("UserController层--->ADD");
		this.userService.add();
	}

}
