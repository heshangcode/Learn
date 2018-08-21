package com.hs.web;

import com.hs.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 认识注解InitBinder
 */
@Controller
public class InitBinderDemoController {
	@GetMapping("/test01")
	public ModelAndView test01() {
		System.out.println("test01");
		return null;
	}

	@GetMapping("/test02")
	public ModelAndView test02(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("test02");
		return null;
	}

	@GetMapping("/test03")
	public ModelAndView test03(Map<String, Object> map) {
		System.out.println("test03");
		return null;
	}

	@GetMapping("/test04")
	public ModelAndView test04(Integer user_id) {
		System.out.println("test04");
		return null;
	}

	@GetMapping("/test05")
	public ModelAndView test05(String name, Integer user_id) {
		System.out.println("test05");
		return null;
	}

	@GetMapping("/test06")
	public ModelAndView test06(User user) {
		System.out.println("test06");
		return null;
	}

	@GetMapping("/test07")
	public ModelAndView test07(User user, String name) {
		System.out.println("test07");
		return null;
	}

	@InitBinder
	public void init01() {
		System.out.println("需要知道什么情况下执行？");
	}
}
