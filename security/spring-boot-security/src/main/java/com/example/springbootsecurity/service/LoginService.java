package com.example.springbootsecurity.service;

import com.example.springbootsecurity.domain.ResponseResult;
import com.example.springbootsecurity.domain.User;

/**
 * @author zhoukai
 */
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
