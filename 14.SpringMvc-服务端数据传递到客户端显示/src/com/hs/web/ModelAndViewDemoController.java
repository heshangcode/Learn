package com.hs.web;

import com.hs.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 使用ModelAndView传递数据
 */
@Controller
public class ModelAndViewDemoController {

	/**
	 * JavaWeb阶段传递数据
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@GetMapping("/server01")
	@ResponseBody   //不处理
	public void test01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("hs", "和尚");
		request.setAttribute("class", "计算机");
		request.setAttribute("number", 8);

		//请求转发传递数据---这个没有通过视图解析器
		request.getRequestDispatcher("/WEB-INF/jsp/result01.jsp").forward(request, response);
	}

	/**
	 * 通过ModelAndView传递数据
	 *
	 * @return
	 */
	@GetMapping("/server02")
	public ModelAndView test02() {
		ModelAndView mav = new ModelAndView();

//		mav.addObject() 没有指明KEY
		//一步一步的追源码，发现一个ModelMap的类实例化对象.用它的addAttribute方法添加，ModelMap又是继承了HashMap
		mav.addObject("title", "通过ModelAndView传递数据");
		mav.addObject("hs", "中国和尚");
		mav.addObject("class", "计算机计科");
		mav.addObject("number", 11);
		mav.setViewName("jsp/result02");    //请求转发，通过视图解析器
		return mav;
	}

	/**
	 * 传递数据没有指明KEY_默认KEY的规则
	 *
	 * @return
	 */
	@GetMapping("/server03")
	public ModelAndView test03() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("integer", 100);
		mav.addObject(200);

		mav.addObject("string", "字符串");
		mav.addObject("悟空");
//		规则：客户端获取没有加key的数据，默认key正常是数据对应的类型的首字母小写 Integer---integer  String---string
//      两个key一样的,只认最后一个
//		double是关键字，不能${double},只能${requestScope["double"] }

		double a = 123.123;
		mav.addObject(a);

		User user = new User();
		user.setMydate(new Date());
		mav.addObject(user);

		mav.setViewName("jsp/result03");    //请求转发，通过视图解析器
		return mav;
	}

}
