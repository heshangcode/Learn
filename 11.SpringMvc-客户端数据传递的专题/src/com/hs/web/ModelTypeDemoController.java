package com.hs.web;

import com.hs.model.HsModel;
import com.hs.model.Role;
import com.hs.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对象专题
 */
@Controller
public class ModelTypeDemoController {
	/**
	 * 简单对象传递
	 *
	 * @return
	 */
	@GetMapping("/client08")
	public ModelAndView test01(User user, String user_name, String sex) {
		System.out.println(user);
		System.out.println("-----依然可以使用简单方式----");
		System.out.println(user_name);
		System.out.println(sex);
		return null;
	}

	/**
	 * 多个对象传递
	 *
	 * @param user
	 * @param role
	 * @return
	 */
	@GetMapping("/client09")
	public ModelAndView test02(User user, Role role) {
		System.out.println(user);
		System.out.println("-----角色----");
		System.out.println(role);
		return null;
	}

	/**
	 * 关联对象_方式一:后台处理
	 *
	 * @param user
	 * @param role
	 * @return
	 */
	@GetMapping("/client10")
	public ModelAndView test03(User user, Role role) {
		//设置关联关系
		user.setRole(role);
		System.out.println(user);
		return null;
	}

	/**
	 * 关联对象_方式二：前台处理
	 *
	 * @param user
	 * @return
	 */
	@GetMapping("/client11")
	public ModelAndView test04(User user) {
		System.out.println(user);
		return null;
	}

	/**
	 * 不同对象，同属性问题，借助第三方类解决问题
	 *
	 * @return
	 */
	@GetMapping("/client12")
	public ModelAndView test05(HsModel hsModel) {
		System.out.println(hsModel.getStudent());
		System.out.println(hsModel.getUser());
		return null;
	}
}
