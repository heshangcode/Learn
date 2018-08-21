package com.hs.web;

import com.hs.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

/**
 * 控制器中的形参测试
 */
@Controller
public class FormalDemoController {

	/**
	 * 查看ServletAPI
	 * 在形参中的类默认情况下是可以进行实例化的
	 * @return
	 */
	@RequestMapping(path = "/test01", method = RequestMethod.GET)
	public ModelAndView test01(HttpServletRequest request, HttpServletResponse response) {  //放在形参被实例化了
		System.out.println(request);
		System.out.println(response);
		return null;
	}

	@RequestMapping(path = "/test02", method = RequestMethod.GET)
	public ModelAndView test02(Map<String, Object> map) {   //默认实例化的HashMap
		System.out.println(map);
		return null;
	}

	@RequestMapping(path = "/test03", method = RequestMethod.GET)
	public ModelAndView test03(String[] hobby) {    //没有实例化
		System.out.println(hobby);
		return null;
	}

	@RequestMapping(path = "/test04", method = RequestMethod.GET)
	public ModelAndView test04(User user) { //实例化了
		System.out.println(user);
		return null;
	}

	@RequestMapping(path = "/test05", method = RequestMethod.GET)
	public ModelAndView test05(ArrayList<String> list) { //List默认不会被实例化
		System.out.println(list);
		return null;
	}

	//什么时候使用基本数据类型和包装类
	//1.当你确定数据一定存在的时候，请使用基本数据类型
	//2.如果数据可能不存在，推荐使用包装类，推荐实体Bean持久化类名尽量使用包装类
	@RequestMapping(path = "/test06", method = RequestMethod.GET)
	public ModelAndView test06(int role_id) {   //报错是因为role_id为null,int不能有null
		System.out.println(role_id);
		return null;
	}

	@RequestMapping(path = "/test07", method = RequestMethod.GET)
	public ModelAndView test07(Integer role_id) {
		System.out.println(role_id);
		return null;
	}

}
