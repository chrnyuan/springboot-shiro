package com.xxx.shiroDemo.filter;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.shiroDemo.sys.entity.Menu;
import com.xxx.shiroDemo.sys.mapper.MenuMapper;
import com.xxx.shiroDemo.utils.SpringContextUtils;
/**
 * 
 * @author ZYK
 * 2019年8月20日 下午2:09:39
 * Desc:
 */
public class URLPathMatchingFilter extends PathMatchingFilter{
	
	@Autowired
	private MenuMapper menuMapper;
	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		if (menuMapper == null) {
			//防止menuMapperbean没有加载到Spring容器
			menuMapper = SpringContextUtils.getContext().getBean(MenuMapper.class);
			String URL = getPathWithinApplication(request);
			System.out.println("reuqestURL:"+URL);
			
			Subject subject = SecurityUtils.getSubject();
			//如果是未登录的
			if (!subject.isAuthenticated()) {
				WebUtils.issueRedirect(request, response, "/login");
				return false;
			}
			QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
			queryWrapper.eq(false, "url", URL);
			List<Menu> menus = menuMapper.selectList(queryWrapper);
			//返回值为空 表示这个路径不需要维护
			if (menus == null) {
				return true;
			}
			
		}
		return false;
	}
}
