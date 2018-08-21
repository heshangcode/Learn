package com.hs.web;

import com.hs.util.DateHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * 接收日期类型的客户端传递数据
 */
@Controller
public class DateDemoController {

	/**
	 * 接收日期类型的客户端传递数据，简写方式
	 * 没有写注解，就写 2018/8/14 15:31:20
	 * 写了注解就按照他的格式来，如果没有写时间，你输入了时间也不会认
	 * 如果一个类中也有这样的属性，同时接收这个时间，注解里也要写格式
	 *
	 * @return
	 */
	/*@GetMapping("/client01")
	public ModelAndView test01(
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date mydate,
			User user) {
		System.out.println(mydate);
		System.out.println(user);
		return null;
	}*/

	/**
	 * 用别人封装好的时间类型转换类，造轮子
	 *
	 * @param mydate
	 * @return
	 */
	@GetMapping("/client01")
	public ModelAndView test01(Date mydate) {
		System.out.println(mydate);
		return null;
	}

	@InitBinder
	public void initDate(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {

				this.setValue(DateHelper.parseDate(text));
			}
		});
	}
}
