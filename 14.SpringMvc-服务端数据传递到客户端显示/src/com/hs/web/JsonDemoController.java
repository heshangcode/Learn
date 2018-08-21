package com.hs.web;

import com.hs.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 返回JSON数据格式
 */
@Controller
public class JsonDemoController {
	/**
	 * JSON格式1：ResponseEntity返回JSON数据格式
	 *
	 * @return
	 */
	@GetMapping("/json01")
	public ResponseEntity<Map<String, Object>> test01() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "马老板");
		map.put("sex", "男");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);    //设置响应方式
		return new ResponseEntity<Map<String, Object>>(map, headers, HttpStatus.CREATED);
	}

	/**
	 * JSON格式1：用List存多条JSON数据
	 *
	 * @return
	 */
	@GetMapping("/json02")
	public ResponseEntity<List<Map<String, Object>>> test02() {
		List<Map<String,Object>> tempList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "马老板");
		map.put("sex", "男");
		tempList.add(map);

		map = new HashMap<String, Object>();
		map.put("name", "悟空");
		map.put("sex", "男");
		tempList.add(map);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);
		return new ResponseEntity<List<Map<String, Object>>>(tempList, headers, HttpStatus.CREATED);
	}

	/**
	 * JSON格式3：简写方式
	 *
	 * @return
	 */
	@GetMapping("/json03")
	@ResponseBody   //把java数据转换为JSON的字符串 存在BUG(IE浏览器不好使，解决办法在springmvc.xml配置)
	public Map<String, Object> test03() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "马老板");
		map.put("sex", "男");
		return map;
	}

	/**
	 * JSON格式4：简写方式
	 *
	 * @return
	 */
	@GetMapping("/json04")
	public @ResponseBody List<Map<String, Object>> test04() {
		List<Map<String,Object>> tempList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", "马老板");
		map.put("sex", "男");
		tempList.add(map);

		map = new HashMap<String, Object>();
		map.put("name", "悟空");
		map.put("sex", "男");
		tempList.add(map);
		return tempList;
	}

	/**
	 * 处理日期格式，需要在user的date属性下加注解,或者springmvc配置全局日期处理
	 * @return
	 */
	@GetMapping("/json05")
	@ResponseBody
	public User test05() {
		User user = new User();
		user.setMydate(new Date());
		return user;
	}
}
