package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 经典异常处理_注解方式
 */
@Controller
public class ExceptionDemoController {

	@GetMapping("/ex01")
	public String test01() {
		int i = 10 / 0; //会报这个错误Request processing failed; nested exception is java.lang.ArithmeticException: / by zero
		return "jsp/result";
	}

	/**
	 * 注解方式，处理异常，程序遇见这个异常，就会执行注解里的内容，
	 *作用范围只有本类有效！！！
	 * @return
	 */
	//里面可以写多个异常，用,隔开，，，其实也可以总的写一个异常Exception,class
	@ExceptionHandler(value = {ArithmeticException.class})
	public ModelAndView exception01(ArithmeticException ex) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("ex", ex);

		mav.setViewName("jsp/error");
		return mav;
	}
}
