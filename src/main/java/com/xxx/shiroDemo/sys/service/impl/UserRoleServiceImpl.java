package com.xxx.shiroDemo.sys.service.impl;

import com.xxx.shiroDemo.sys.entity.UserRole;
import com.xxx.shiroDemo.sys.mapper.UserRoleMapper;
import com.xxx.shiroDemo.sys.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author zyk
 * @since 2019-08-20
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
