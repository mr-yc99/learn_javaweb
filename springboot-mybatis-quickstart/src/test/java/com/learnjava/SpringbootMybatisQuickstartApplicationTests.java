package com.learnjava;

import com.learnjava.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void testSelectUser(){
		userMapper.list().stream().forEach(user -> {
			System.out.println(user);
		});

	}

}







