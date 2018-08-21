package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 请求方式
 */
@Controller
@RequestMapping("/http")
public class MethodDemoController {

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public ModelAndView GET() {
		System.out.println("GET请求：只能做查询操作");
		return null;
	}

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public ModelAndView POST() {
		System.out.println("POST请求：添加操作");
		return null;
	}

	@RequestMapping(path = "/user", method = RequestMethod.DELETE)
	public ModelAndView DELETE() {
		System.out.println("DELETE请求：删除操作");
		return null;
	}

	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	public ModelAndView PUT() {
		System.out.println("PUT请求：更新操作[等幂(也就是全部更新)]");
		return null;
	}

	@RequestMapping(path = "/user", method = RequestMethod.PATCH)
	public ModelAndView PATCH() {
		System.out.println("PATCH请求：更新操作[不等幂]");
		return null;
	}

}
