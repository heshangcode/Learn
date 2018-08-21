package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/sys/test01")
	public String test01() {
		System.out.println("Controller层test01方法");
		return "jsp/result01";
	}

	@GetMapping("/vip/test02")
	public String test02() {
		System.out.println("Controller层test02方法");
		return "jsp/result02";
	}

}
