package com.example.springbootsecurity;

import com.example.springbootsecurity.domain.User;
import com.example.springbootsecurity.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootSecurityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;
	@Test
	void testUserMapper() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}
}
