package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/ex02")
	public String test01() {
		int i = 10 / 0; //会报这个错误Request processing failed; nested exception is java.lang.ArithmeticException: / by zero
		return "jsp/result";
	}
	@GetMapping("/ex03")
	public String test02() {
		int[] array = {1,2,3};
		System.out.println(array[5]);
		return "jsp/result";
	}
}
