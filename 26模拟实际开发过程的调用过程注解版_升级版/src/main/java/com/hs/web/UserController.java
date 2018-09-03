package com.hs.web;

import com.hs.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//@Component  //相当于<bean id="userController" class="com.hs.web.UserController"/>
@Controller //跟上面意思一样，只是为了知名见意
public class UserController {
	//简写方式，写个就不用写set方法了
	//如果你所在的公司用了测试框架(不是我现在用的单元测试框架)，那么不建议使用简写方式，对测试有影响
	//@Resource(name = "userServiceImpl")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userServiceImpl") //相当于p:userService-ref="userServiceImpl"
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void add() {
		System.out.println("UserController层--->ADD");
		this.userService.add();
	}

}
