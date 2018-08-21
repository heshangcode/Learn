package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 简单的数据类型获取
 */
@Controller
public class SimpleTypeDemoController {
	/**
	 * javaweb形式获取
	 *
	 * @return
	 */
	@RequestMapping("/client01")
	public ModelAndView test01(HttpServletRequest request) {
		String user_name = request.getParameter("user_name");
		String[] hobby = request.getParameterValues("hobby");
		System.out.println("姓名" + user_name);
		for (String s : hobby) {
			System.out.print(s + "--");
		}
		return null;
	}

	/**
	 * 通过@RequestParam注解获取数据，注解还自动转换类型,value和name一样
	 * required是否必须要接受到这个值，默认true
	 * defaultValue默认设置，如果没有接收到值，则默认设置值
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/client02")
	public ModelAndView test02(@RequestParam(value = "user_name", required = false) String name,
	                           @RequestParam(name = "user_id", required = false, defaultValue = "1111") Integer id) {
		System.out.println("姓名" + name);
		System.out.println("ID" + id);
		return null;
	}

	/**
	 * 简写方式，传递的名称和接收的形参名字一样就可以，required默认为false
	 * @param name
	 * @param id
	 * @return
	 */
	@RequestMapping("/client03")
	public ModelAndView test03(String user_name,Integer user_id) {
		System.out.println("姓名" + user_name);
		System.out.println("ID" + user_id);
		return null;
	}
}
