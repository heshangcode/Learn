package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * 数组的获取方式
 */
@Controller
public class ArrayTypeDemoController {
	/**
	 * 超链接获取数组
	 *
	 * @return
	 */
	@GetMapping("/client04")
	public ModelAndView test01(@RequestParam(name = "role_id") Integer[] roles) {
		System.out.println(Arrays.asList(roles));
		return null;
	}

	/**
	 * 复选框传递数组
	 *
	 * @param roles
	 * @return
	 */
	@GetMapping("/client05")
	public ModelAndView test02(String[] hobby) {
		if (hobby != null) {
			System.out.println(Arrays.asList(hobby));
		} else {
			System.out.println("您没有爱好！");
		}

		return null;
	}

	/**
	 * 文本框传递数据
	 *
	 * @param hobby
	 * @return
	 */
	@GetMapping("/client06")
	public ModelAndView test03(String[] hobby) {
		System.out.println(Arrays.asList(hobby));
		return null;
	}

	/**
	 * 多选列表传递数组
	 *
	 * @param hobby
	 * @return
	 */
	@GetMapping("/client07")
	public ModelAndView test04(String[] hobby) {
		if (hobby != null) {
			System.out.println(Arrays.asList(hobby));
		} else {
			System.out.println("您没有爱好！！");
		}
		return null;
	}
}
