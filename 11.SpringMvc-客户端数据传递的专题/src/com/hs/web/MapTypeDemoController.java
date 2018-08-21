package com.hs.web;

import com.hs.model.HsModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Map_分页保存查询
 */
@Controller
public class MapTypeDemoController {

	/**
	 * map接收数据，通过第三方类
	 * @param hsModel
	 * @return
	 */
	@GetMapping("/client13")
	public ModelAndView test01(HsModel hsModel) {
		System.out.println(hsModel.getQuery());
		return null;
	}
}
