package com.xxx.shiroDemo.sys.service.impl;

import com.xxx.shiroDemo.sys.entity.Role;
import com.xxx.shiroDemo.sys.mapper.RoleMapper;
import com.xxx.shiroDemo.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author zyk
 * @since 2019-08-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
