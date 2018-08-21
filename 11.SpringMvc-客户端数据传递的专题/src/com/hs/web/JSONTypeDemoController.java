package com.hs.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 前台传来JSON格式字符串处理
 */
@Controller
public class JSONTypeDemoController {
	/**
	 * 整个流程是，前台JavaScript转换json，把json传给后台，后台再转换为java对象，进行修改等操作，
	 * 然后这个对象再通过注解@ResponseBody转换为前台data接收到的JSON格式的字符串
	 * @param hs
	 * @return
	 * @throws IOException
	 */
	@GetMapping("json01")
	@ResponseBody
	public User json01(String hs) throws IOException {

		System.out.println(hs);
		//将前台传过来的json格式对象转换为java对象
		ObjectMapper objectMapper = new ObjectMapper();
		User user = objectMapper.readValue(hs, User.class);
		user.setSex("女");

		return user;
	}

	/**
	 * 通过ajax传递过来数据，@RequestBody相当于完成了上面的
	 * ObjectMapper objectMapper = new ObjectMapper();
	 * 		User user = objectMapper.readValue(hs, User.class);
	 * 	这两步，但是前提是传过来的字段名和user类的属性名一样，才能正常转换
	 * @param user
	 * @return
	 */
	@PostMapping("/json02")
	@ResponseBody
	public User json02(@RequestBody User user) {
		user.setUser_name("八戒");
		return user;
	}
}
