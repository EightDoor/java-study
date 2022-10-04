package com.example.springbootsecurity.controller;

import com.example.springbootsecurity.domain.ResponseResult;
import com.example.springbootsecurity.domain.User;
import com.example.springbootsecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoukai
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        // 登录
        return loginService.login(user);
    }
}
