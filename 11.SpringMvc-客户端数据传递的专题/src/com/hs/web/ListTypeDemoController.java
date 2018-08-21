package com.hs.web;

import com.hs.model.HsModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * List数据_一般做批量添加
 */
@Controller
public class ListTypeDemoController {
	@GetMapping("/client14")
	public ModelAndView test01(HsModel hsModel) {
		System.out.println(hsModel.getStudentList());
		return null;
	}
}
