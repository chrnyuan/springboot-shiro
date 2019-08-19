package com.xxx.shiroDemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControler {
	@GetMapping("/login")
	public String toLogin(){
		return "login";
	}

	@RequestMapping("/user/update")
	public String toUpdate(){
		return "/user/update";
	}
	
	@RequestMapping("/user/add")
	public String toAdd(){
		return "/user/add";
	}
	
	@RequestMapping("/index")
	public String toindex(){
		return "/index";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username"+username);
		Subject subject = SecurityUtils.getSubject();
		//把账号密码存入UsernamePasswordToken对象
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		try {
			subject.login(token);
			Session session = subject.getSession();
			session.setAttribute("subject", subject);
			return "redirect:index";
		} catch (Exception e) {
			model.addAttribute("error", "验证失败");
			System.out.println("验证失败");
		}
		
		return "/login";
	}
}
