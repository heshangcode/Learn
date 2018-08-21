package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对要转换的字符串类型进行处理
 */
@Controller
public class StringDemoController {

	@GetMapping("hs01")
	public ModelAndView test01(Integer user_id) {
		System.out.println(user_id);
		return null;
	}

	@GetMapping("hs02")
	public ModelAndView test02(String user_name) {
		System.out.println(user_name);
		return null;
	}

	@GetMapping("hs03")
	public ModelAndView test03(String user_name, Integer user_id) {
		System.out.println(user_name);
		System.out.println(user_id);
		return null;
	}

	/**
	 * 时间格式的转换
	 *
	 * @param date1
	 * @return
	 */
	@GetMapping("hs04")
	public ModelAndView test04(Date date1) {
		System.out.println("日期为" + date1);
		return null;
	}

	@InitBinder
	public void init01(WebDataBinder binder) {
		//监控要转换(String)的数据类型
		binder.registerCustomEditor(String.class, /*匿名对象*/new PropertyEditorSupport() {
			//重写了setAsText方法
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				System.out.println("之前接收的值----" + text);
				//对数据重新处理赋值，赋值给形参user_name
				this.setValue("对数据处理之后的值----" + text + "悟空");
			}
		});

		//监控Integer类型
		binder.registerCustomEditor(Integer.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				System.out.println(text);
				this.setValue("999");
			}
		});
	}

	@InitBinder
	public void init02(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date date = df.parse(text);
					this.setValue(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
		});
	}
}

