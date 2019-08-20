package com.xxx.shiroDemo.sys.mapper;

import com.xxx.shiroDemo.sys.entity.User;

import java.util.Set;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zyk
 * @since 2019-08-20
 */
public interface UserMapper extends BaseMapper<User> {

	Set<String> queryAllPerms(String userId);
}
