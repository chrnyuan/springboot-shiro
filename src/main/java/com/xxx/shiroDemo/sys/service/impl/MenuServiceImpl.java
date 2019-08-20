package com.xxx.shiroDemo.sys.service.impl;

import com.xxx.shiroDemo.sys.entity.Menu;
import com.xxx.shiroDemo.sys.mapper.MenuMapper;
import com.xxx.shiroDemo.sys.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author zyk
 * @since 2019-08-20
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
