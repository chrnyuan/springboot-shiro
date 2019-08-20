package com.xxx.shiroDemo.sys.service;

import java.util.Set;

import com.xxx.shiroDemo.sys.entity.User;

public interface ShiroService {

	/**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(String userId);

    User queryUserByName(String username);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     */
    User queryUser(Long userId);
	
}
