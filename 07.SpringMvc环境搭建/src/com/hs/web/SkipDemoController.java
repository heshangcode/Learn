package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * 跳转专题：请求转发，重定向，一个controller跳到另外一个controller
 */
@Controller
public class SkipDemoController {
	//设置映射的路径
	//当我在浏览器中输入 http://127.0.0.1:8080/mvc/hs01
	@RequestMapping("/hs01")
	/*从Controller跳转到jsp_默认是请求转发
	请求转发，页面不跳转，可以访问WEB-INF路径下的东西*/
	public ModelAndView test01(){
		ModelAndView nav = new ModelAndView();
		nav.setViewName("/WEB-INF/jsp/result01.jsp");
		return nav;
	}
	/*从Controller跳转到jsp_默认是请求转发
	请求转发，页面不跳转，可以访问WEB-INF路径下的东西*/
	@RequestMapping("/hs011")
	public ModelAndView test011(){
		ModelAndView nav = new ModelAndView();
		nav.setViewName("jsp/result01");   //如果设置了jsp请求转发的视图解析器
		return nav;
	}

	@RequestMapping("/hs02")
	/*从Controller跳转到jsp_重定向
	但是官方不推荐直接重定向到jsp页面
	重定向，页面跳转，不可以访问WEB-INF路径下的东西*/
	public ModelAndView test02(){
		ModelAndView nav = new ModelAndView();
		nav.setViewName("redirect:/test01.jsp");
		return nav;
	}

	/**从Controller跳转到Controller_请求转发
	 * 当配置了JSP的请求转发视图解析器后从Controller跳转到另外一个Controller，
	 * 必须指明前缀：forward/redirect
	 * @return
	 */
	@RequestMapping("/hs03")
	public ModelAndView test03() {
		ModelAndView nav = new ModelAndView();
		nav.setViewName("forward:/hs011");  //这个写forward的原因是，避免jsp请求转发视图解析器，把hs011解析成了jsp页面UrlBasedViewResolver.FORWARD_URL_PREFIX=forward
//		nav.setViewName("/hs01");
		return nav;
	}

	/*从Controller跳转到Controller_重定向*/
	@RequestMapping("/hs04")
	public ModelAndView test04() {
		ModelAndView nav = new ModelAndView();
		nav.setViewName(UrlBasedViewResolver.REDIRECT_URL_PREFIX+"/hs01");   //UrlBasedViewResolver.REDIRECT_URL_PREFIX   == redirect:
		return nav;
	}
}
