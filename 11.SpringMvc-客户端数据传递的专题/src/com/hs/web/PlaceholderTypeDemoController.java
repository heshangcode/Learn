package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 占位符传递简单数据
 */
@Controller
public class PlaceholderTypeDemoController {
	@GetMapping("/client15/{id}/{name}")
	public ModelAndView test01(
			@PathVariable("id") int user_id,/*占位符的名字和形参不一样，在PathVariable中需要写占位符的名字*/
			@PathVariable String name,/*一样则可以省略*/
			String sex  /*@RequestParam的简写方式*/
	) {
		System.out.println(user_id);
		System.out.println(name);
		System.out.println(sex);
		return null;
	}
	@GetMapping("/client16/{id}/{name}")
	public ModelAndView test01(
			@PathVariable Map<String,Object> map,/*占位符的名字作为key值*/
			String sex  /*@RequestParam的简写方式*/
	) {
		System.out.println(map);
		System.out.println(sex);
		return null;
	}
}
