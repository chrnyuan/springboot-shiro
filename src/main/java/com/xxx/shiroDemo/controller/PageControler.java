package com.xxx.shiroDemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.shiroDemo.sys.entity.User;
import com.xxx.shiroDemo.sys.service.IUserService;
import com.xxx.shiroDemo.utils.R;

import freemarker.template.SimpleHash;

@Controller
public class PageControler {
	@Autowired
	private IUserService userService;
	@GetMapping("/login")
	public String toLogin(){
		return "login";
	}
	@RequiresPermissions(value="user:update")
	@RequestMapping("/user/update")
	public String toUpdate(){
		return "/user/update";
	}
	@GetMapping("/user/add")
	public String toAdd(){
		return "/user/add";
	}
	
	
	@RequestMapping("/index")
	public String toindex(){
		return "/index";
	}
	@RequestMapping("unauthorized")
	public String toUnauthorized(){
		return "unauthorized";
	}
	
	@ResponseBody
	@PostMapping("/addUser")
	public R addUser(HttpServletRequest request ,HttpServletResponse response){
		System.out.println("-----------------------华丽的分割线-------------------------");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		
		String pwd = new org.apache.shiro.crypto.hash.SimpleHash("md5",password,salt).toString();
		System.out.println(pwd);
		User user = new User();
		user.setUserName(username);
		user.setPassword(pwd);
		user.setSalt(salt);
		boolean b = userService.save(user );
		if (b) {
			return R.ok(); 
		}
		return R.error(1,"添加失败");
	}
}
