package com.xxx.application.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xxx.shiroDemo.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class TestDemo {
//	@Autowired
//	private UserMapper userMapper;
//	
//	@Test
//	public void select(){
//		
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.eq("userName", "111");
//		User user = userMapper.selectOne(queryWrapper);
//		System.out.println("user"+user);
//	
//	}
	
}
