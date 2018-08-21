package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 映射路径的定义方式
 */
@Controller//(value = "hsController")   //这就是给controller取的名字，默认是类名首字母小写
@RequestMapping("/cy42")     //这个是设置本类总的路径,比如你访问这个类的test01，网址栏就要写localhost:8080/mvc/cy42/test01
public class PathDemoController {

	@RequestMapping(path = {"/test01","/test02"})
	public ModelAndView test01() {
		System.out.println("多路径访问，用数组这样设置");
		return null;
	}

	@RequestMapping(path = "/test03")
	public ModelAndView test03() {
		System.out.println("一个路径");
		return null;
	}

	@RequestMapping("/test04")
	public ModelAndView test04() {
		System.out.println("只有一个路径属性的值，可以省略");
		return null;
	}

	//1.在映射路径中可以适应通配符 *
	//A.谁描述的清楚就找谁   eg:/test01 找/test01
	//B.通配符使用的很少
	@RequestMapping("/*")
	public ModelAndView test05() {
		System.out.println("可以使用通配符");
		return null;
	}

	@RequestMapping("/**")
	public ModelAndView test06() {
		System.out.println("任意层次");
		return null;
	}

	//使用占位符，一般只是传递主键和简单的字符串
	// 完成REST风格的路径，优先级比通配符高
	@RequestMapping("/{user_id}")   //user_id接收输入的路径值
	public ModelAndView test06(@PathVariable("user_id") String id) {    //使用注解，把user_id接收到的值赋给id
		System.out.println("使用占位符,"+id);
		System.out.println(id);
		return null;
	}
}
