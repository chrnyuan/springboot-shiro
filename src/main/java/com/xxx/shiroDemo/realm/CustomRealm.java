package com.xxx.shiroDemo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm{
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取账号密码
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		//从主体登陆穿过来的token获取主体提交的用户名
		String username = (String) token.getPrincipal();
		System.out.println("username:"+username);
		//2.通过主体提交的用户名去数据库中获取凭证（通过用户名获得密码）
		String password = gerPasswordByUserName(username);
		if (password == null) {
			return null;
		}
		//创建认证对象
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, "CustomRealm");
		
		return authenticationInfo;
	}
	
	/**
	 * 因为没有集成数据库，使用假数据 密码为111
	 * @param username
	 * @return
	 */
	String gerPasswordByUserName(String username){
		if (username.equals("111")) {
			return "111";
		}
		return null;
	}
	
	
}
