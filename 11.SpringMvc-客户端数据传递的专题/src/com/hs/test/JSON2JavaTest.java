package com.hs.test;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.model.Role;
import com.hs.model.User;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JSON2JavaTest {

	/**
	 * Java对象和JSON字符串的互相转换
	 */
	@Test
	public void test01() throws IOException {
		Map<String,Object> map = new HashMap<>();
		map.put("user_name","悟空");
		map.put("age", 500);
		map.put("hobby",/*静态初始化数据*/ new String[]{"music","book"});
		System.out.println("转换之前的Map:"+map);

		//1.java对象转JSON格式的字符串
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(map);
		System.out.println("java对象转JSON格式的字符串:"+jsonString);

		//2.JSON字符串转换为java对象
		Map<String, Object> hsMap = objectMapper.readValue(jsonString, Map.class);
		System.out.println("JSON字符串转换为java对象:"+hsMap);
	}

	/**
	 * java对象转json字符串__自定义对象互相转换
	 * @throws Exception
	 */
	@Test
	public void test02() throws Exception {
		User user = new User();
		user.setUser_id(100);
		user.setUser_name("八戒");
		user.setSex("男");

		Role role = new Role();
		role.setRole_name("超级管理员");
		//建立联系
		user.setRole(role);
		System.out.println("转换之前的User:"+user);

		//1.java对象转json字符串
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(user);
		System.out.println("java对象转json字符串:"+jsonString);

		//2.json字符串转java对象
		User hsUser = objectMapper.readValue(jsonString, User.class);
		System.out.println("json字符串转java对象:"+hsUser);
	}
	/**
	 * java对象转json字符串__集合
	 * @throws Exception
	 */
	@Test
	public void test03() throws Exception {
		List<User> userList = new ArrayList<>();
		User user = new User();
		user.setUser_id(100);
		user.setUser_name("八戒");
		user.setSex("男");
		Role role = new Role();
		role.setRole_name("超级管理员");
		user.setRole(role);
		userList.add(user);

		user = new User();
		user.setUser_id(100);
		user.setUser_name("悟空");
		user.setSex("男");
		role = new Role();
		role.setRole_name("管理员");
		user.setRole(role);
		userList.add(user);

		System.out.println("转换之前的List<User>:"+userList);

		//1.java对象转json字符串
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(userList);
		System.out.println("java对象转json字符串:"+jsonString);

		//2.json字符串转java对象
		System.out.println("组成的List<Map>:"+objectMapper.readValue(jsonString, List.class)); //组成的是List<Map>
		JavaType t = objectMapper.getTypeFactory().constructParametricType(List.class, User.class);
		List<User> tempList = objectMapper.readValue(jsonString, t);
		System.out.println("json字符串转java对象:"+tempList);
	}

}
