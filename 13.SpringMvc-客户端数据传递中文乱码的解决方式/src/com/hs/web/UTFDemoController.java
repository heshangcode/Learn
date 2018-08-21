package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

/**
 * 中文乱码问题
 */
@Controller
public class UTFDemoController {

	/**
	 * Tomcat7中GET请求方式中文乱码-传统方式解决方案
	 * @param user_name
	 * @return
	 * @throws UnsupportedEncodingException
	 */
//	@PostMapping("/client01")
	@GetMapping("/client01")
	public ModelAndView test01(String user_name) throws UnsupportedEncodingException {
		//验证编码格式
		//boolean equals = user_name.equals(new String(user_name.getBytes("UTF-8"), "UTF-8"));
		byte[] a = user_name.getBytes("ISO8859-1"); //用给定的编码，把字符串编码到byte序列
		String b = new String(a,"UTF-8");   //通过使用指定的编码解码指定的 byte 数组，构造一个新的 String。
		System.out.println(b);
		//简写
//		user_name = new String(user_name.getBytes("ISO8859-1"),"UTF-8");
		//tomcat8 get请求默认为UTF-8
		return null;
	}

	/**
	 * post请求中文乱码-在web.xml中配置过滤器
	 * @param user_name
	 * @return
	 */
	@PostMapping("/client03")
	public ModelAndView test03(String user_name) {
		System.out.println(user_name);
		return null;
	}
}
