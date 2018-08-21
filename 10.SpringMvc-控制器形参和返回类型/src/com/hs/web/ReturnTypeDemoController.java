package com.hs.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制器中的数据返回类型
 */
@Controller
public class ReturnTypeDemoController {

	//	@RequestMapping(path = "/hs01",method = {RequestMethod.GET,RequestMethod.POST})
//	简写
	@GetMapping("/hs01")
//	@PostMapping
//	@PutMapping................
	public ModelAndView test01() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/result");
		return mav;
	}

	@GetMapping("/hs02")
	public void test02() {
		System.out.println("void情况一：默认情况下是按照路径进行请求转发的的查找页面访问的是hs02.jsp");
	}

	/**
	 * 通过servlet的跳转方式_个人不推荐
	 */
	@GetMapping("/hs03")
	public void test03(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);
	}

	/**
	 * 直接输出页面
	 */
	@GetMapping("/hs04")
	public void test04(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1 style='color:blue'>和尚</h1>");
		out.flush();
		out.close();
	}

	/**
	 * 默认情况下就是请求转发查找页面
	 * 先jsp请求转发解析器，再找jsp/result页面
	 *
	 * @return
	 */
	@GetMapping("/hs05")
	public String test05() {
		return "jsp/result";
	}

	/**
	 * 也可以设置重定向
	 */
	@GetMapping("/hs06")
	public String test06() {
		return "redirect:/hs05";
	}

	/**
	 * 输出内容_如何处理,需要设置编码通过过滤器
	 */
	@GetMapping("/hs07")
	public ResponseEntity<String> test07() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);    //设置响应的内容格式
		String content = "<h1 style='color:blue'>沙僧222</h1>";
		return new ResponseEntity<String>(content, headers, HttpStatus.CREATED);
	}

	/**
	 * 输出内容_简写方式
	 */
	@GetMapping(path = "/hs08",produces = "text/html;charset=UTF-8")    //设置响应的内容格式和编码，后面配置过滤器就可以不写该代码了
	@ResponseBody   //针对于你返回的数据的类型进行转换，可以转换任意类型，但是需要第三方库的支持
	public String test08() {
		return "<h1 style='color:blue'>沙僧222</h1>";
	}

	///=================返回任意数据类型[服务端返回数据]=======================
	/**
	 * 传统模式直接输出JSON数据
	 */
	@GetMapping("/hs09")
	public void test09(HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("hs","和尚");
		map.put("class", "计算机");
		map.put("flag", true);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr = objectMapper.writeValueAsString(map);
		out.write(jsonStr);
		out.flush();
		out.close();
	}

	/**
	 * 通过JackJson返回Json数据
	 * @return
	 */
	@RequestMapping("/hs10")
	public ResponseEntity<Map<String, Object>> test10() {
		Map<String, Object> map = new HashMap<>();
		map.put("hs","111");
		map.put("class", "2222");
		map.put("flag", true);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);
		return new ResponseEntity<Map<String, Object>>(map, headers, HttpStatus.CREATED);
	}

	/**
	 * 通过ResponseBody处理数据
	 * @return
	 */
	@RequestMapping("/hs11")
	@ResponseBody   //对返回的数据进行处理，如果不是字符串，通过Jackson转换成json格式字符串
	//遗留问题：在IE浏览器该注解有BUG
	public Map<String, Object> test11() {
		Map<String, Object> map = new HashMap<>();
		map.put("hs","和尚");
		map.put("class", "计算机");
		map.put("flag", true);

		return map;
	}
	/**
	 * 通过ResponseBody处理数据
	 * 自定义的类型
	 * @return
	 */
	@RequestMapping("/hs12")
	@ResponseBody   //对返回的数据进行处理，如果不是字符串，通过Jackson转换成json格式字符串
	public User test12() {
		User user = new User();
		user.setRole_id(19999);
		user.setName("和尚");
		return user;
	}
}
