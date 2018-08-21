package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**控制传递的参数
 * 如果没有传递参数会报400的错误
 */
@Controller
@RequestMapping("/vip")
public class ParamsDemoController {

	@RequestMapping(path = "/param01",params = "hs=tomcat")
	public ModelAndView test01() {
		System.out.println("你必须要传递一下形式的数据里满足params里的数据，eg:param01?hs=tomcat&id=100");
		return null;
	}

	@RequestMapping(path = "/param02",params = {"hs!=tomcat","method=add"})
	public ModelAndView test02() {
		System.out.println("!=");
		return null;
	}
}
