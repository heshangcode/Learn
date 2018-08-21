package com.hs.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * ControllerAdvice这个表示监听只要有Controller的类的异常，同样如果自身类有注解监听，满足谁近就运行谁的原则
 */
@ControllerAdvice
public class ExceptionAllController {

	/**
	 * 监听Controller类的异常方式一
	 *
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = {Exception.class})
	public ModelAndView exception01(Exception ex) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("ex", ex);

		mav.setViewName("jsp/error02");
		return mav;
	}

	/**
	 * 监听Controller类的异常方式二自定义异常
	 * @param ex
	 * @param model
	 * @return
	 */
	@ExceptionHandler(value = {Exception.class})
	public String exception02(Exception ex, Model model) {
		//判断类的类型
		if (ex instanceof ArrayIndexOutOfBoundsException) {
			model.addAttribute("message", "数组越界异常");//给客户看的
			model.addAttribute("ex", ex);
//			return "jsp/error";
		}

		if (ex instanceof ArithmeticException) {
			model.addAttribute("message", "运算异常");    //给客户看的
			model.addAttribute("ex", ex);
//			return "jsp/error";
		}

		//处理自定义异常
		return "jsp/error";
	}

	/**
	 * 监听Controller类的异常方式二自定义异常____返回json格式
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = {Exception.class})
	@ResponseBody
	public Map<String,Object> exception03(Exception ex) {
		Map<String, Object> map = new HashMap<String,Object>();
		//判断类的类型
		if (ex instanceof ArrayIndexOutOfBoundsException) {
			map.put("message", "数组越界异常");//给客户看的
			map.put("ex", ex);
//			return "jsp/error";
		}

		if (ex instanceof ArithmeticException) {
			map.put("message", "运算异常");    //给客户看的
			map.put("ex", ex);
//			return "jsp/error";
		}

		//处理自定义异常
		return map;
	}
}
