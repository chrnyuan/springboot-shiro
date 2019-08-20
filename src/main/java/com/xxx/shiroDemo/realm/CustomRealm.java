package com.xxx.shiroDemo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxx.shiroDemo.sys.entity.User;
import com.xxx.shiroDemo.sys.service.ShiroService;

import freemarker.template.SimpleHash;

/**
 * 自定义域
 * 
 * @author ZYK 2019年8月19日 下午1:29:01 Desc:
 */
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private ShiroService shiroService;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权逻辑");
		String username = (String) principals.getPrimaryPrincipal();
		
//		shiroService.getUserPermissions(userId);
		
		return null;
	}

	/**
	 * 认证
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 从主体登陆穿过来的token获取主体提交的用户名
		String username = (String) token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		// 2.通过主体提交的用户名去数据库中获取凭证（通过用户名获得密码）
		User user = shiroService.queryUserByName(username);
		System.out.println("user--------------"+user);
		if (user == null)
			throw new UnknownAccountException("用户名或密码错误！");
		/*if (!user.getPassword().equals(password)) {
			throw new IncorrectCredentialsException("用户名或密码错误");
		}*/
		String salt = user.getSalt();
		String pwd = new org.apache.shiro.crypto.hash.SimpleHash("md5", password, salt).toString();
		if (!user.getPassword().equals(pwd)) {
			return null;
		}
		
		// 创建认证对象
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,password,getName());
		return authenticationInfo;

	}

	
	
}
