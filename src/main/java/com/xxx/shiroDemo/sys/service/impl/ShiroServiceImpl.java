package com.xxx.shiroDemo.sys.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.shiroDemo.sys.entity.User;
import com.xxx.shiroDemo.sys.mapper.MenuMapper;
import com.xxx.shiroDemo.sys.mapper.RoleMapper;
import com.xxx.shiroDemo.sys.mapper.RoleMenuMapper;
import com.xxx.shiroDemo.sys.mapper.UserMapper;
import com.xxx.shiroDemo.sys.mapper.UserRoleMapper;
import com.xxx.shiroDemo.sys.service.ShiroService;
@Service
public class ShiroServiceImpl implements ShiroService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleMenuMapper roleMenuMapper;
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public Set<String> getUserPermissions(String userId) {
		Set<String> allPerms = userMapper.queryAllPerms(userId);
		
		return allPerms;
	}

	@Override
	public User queryUserByName(String username) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("userName", username);
		System.out.println(userMapper.selectOne(queryWrapper));
		return userMapper.selectOne(queryWrapper);
	}

	@Override
	public User queryUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
