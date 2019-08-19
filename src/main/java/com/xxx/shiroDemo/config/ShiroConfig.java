package com.xxx.shiroDemo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xxx.shiroDemo.realm.CustomRealm;

@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean WebFilter(){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		
		//创建Map用来添加需要拦截或需要放行的url
		Map<String, String> filterChainMap = new  LinkedHashMap<String, String>();
		/**
		 *把需要拦截的路径添加进Map
		 */
		//authc 所有url必须通过认证才可以访问，；anon所有url都可以匿名访问
		filterChainMap.put("/login", "anon");
		filterChainMap.put("/**", "authc");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
		//设置拦截请求的url
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		return shiroFilterFactoryBean;
		
	}
	/**
	 * 安全管理器
	 * @return
	 */
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//将自定义的Realm 交给安全管理器管理
		securityManager.setRealm(new CustomRealm());
		
		return securityManager;
	}

}

