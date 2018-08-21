package com.hs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sys")
public class LoginController {

	/**
	 * 在地址栏输入/sys/login 进行请求转发跳转页面
	 *
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "jsp/login";
	}

	/**
	 * 表单提交验证，存入session
	 *
	 * @param account
	 * @param request
	 * @return
	 */
	@PostMapping("/login")
	public String login(String account,HttpServletRequest request){
		System.out.println(account);
		HttpSession session  = request.getSession();
		if("admin".equals(account)){
			session.setAttribute("session_user", account);
			//redirect重定向跳到另外一个controller里
			return "redirect:/sys/main";
		}
		return "jsp/login";
	}

	/**
	 * 登录成功重定向到这个controller，然后这个controller请求转发到一个页面
	 * @return
	 */
	@GetMapping("/main")
	public String main(){
		return "jsp/result01";
	}
}
