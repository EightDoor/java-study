package com.example.springbootsecurity;

import com.example.springbootsecurity.domain.User;
import com.example.springbootsecurity.mapper.UserMapper;
import com.example.springbootsecurity.utils.JwtUtil;
import com.example.springbootsecurity.utils.RedisUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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


	@Test
	public void testBcryptPasswordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String encode = passwordEncoder.encode("123456");
//		String encode2 = passwordEncoder.encode("123456");
//		System.out.println(encode);
//		System.out.println(encode2);

		// 比较密码是否相等
		// $2a$10$L41bKqSWA.2ylph7/9DfM.c9qhVrfOcD6ndAz8y5cSluzGh6xituu
		boolean b = passwordEncoder.matches("123456", "$2a$10$L41bKqSWA.2ylph7/9DfM.c9qhVrfOcD6ndAz8y5cSluzGh6xituu");
		System.out.println(b);
	}

	@Test
	public void getToken() {
		// 生成token
		String jwt = JwtUtil.createJWT("12345");
		System.out.println(jwt);
		// 解析token
//		Claims claims = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzMWJmZjE4OGU4ZmE0YzgxOWUxNjc1NWU0ZTA4YWY5YyIsInN1YiI6IjEyMzQ1IiwiaXNzIjoiemsiLCJpYXQiOjE2NjQ4NTQ0NjgsImV4cCI6MTY2NDg1ODA2OH0.lg93mC_eSp9kbLxsOhCa-myaSBhIwYZR2Tn12VufHms");
//		String subject = claims.getSubject();
//		System.out.println(subject);
	}

	@Autowired
	RedisUtil redisUtil;
	@Test
	public void redisTest() {
		boolean set = redisUtil.set("测试", "123333");
		System.out.println(set);
	}
}
