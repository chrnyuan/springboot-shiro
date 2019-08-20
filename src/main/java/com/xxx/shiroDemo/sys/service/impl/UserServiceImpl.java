package com.xxx.shiroDemo.sys.service.impl;

import com.xxx.shiroDemo.sys.entity.User;
import com.xxx.shiroDemo.sys.mapper.UserMapper;
import com.xxx.shiroDemo.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zyk
 * @since 2019-08-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
