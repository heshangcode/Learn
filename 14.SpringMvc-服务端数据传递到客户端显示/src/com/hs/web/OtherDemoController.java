package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * 其他的方式传递数据
 */
@Controller
public class OtherDemoController {

	/**
	 *其他1--通过Map在形参中实例化
 	 * @param map
	 * @return
	 */
	@GetMapping("/server04")
	public String test01(Map<String,Object> map) {
		map.put("title", "Map在形参中定义，可以传递数据");
		map.put("hs", "123");
		map.put("class", "12222");
		map.put("number", 1111);
		return "jsp/result04";  //通过请求转发视图解析器
	}

	/**
	 * 其他2--通过ModelMap在形参中实例化
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/server05")
	public String test02(ModelMap modelMap) {
		modelMap.addAttribute("title", "ModelMap进行传递数据");
		modelMap.addAttribute("hs", "123");
		modelMap.addAttribute("class", "12222");
		modelMap.addAttribute("number", 1111);
		return "jsp/result04";  //通过请求转发视图解析器
	}

	/**
	 * 其他3--通过Model接口传递数据
	 * @param model
	 * @return
	 */
	@GetMapping("/server06")
	public String test03(Model model) {
		model.addAttribute("title", "Model接口进行传递数据");
		model.addAttribute("hs", "123");
		model.addAttribute("class", "12222");
		model.addAttribute("number", 1111);
		return "jsp/result04";  //通过请求转发视图解析器
	}
}
