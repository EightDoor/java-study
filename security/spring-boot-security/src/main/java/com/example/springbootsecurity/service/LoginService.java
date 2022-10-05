package com.example.springbootsecurity.service;

import com.example.springbootsecurity.domain.ResponseResult;
import com.example.springbootsecurity.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author zhoukai
 */
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
