package com.example.springbootsecurity.service.impl;

import com.example.springbootsecurity.domain.LoginUser;
import com.example.springbootsecurity.domain.ResponseResult;
import com.example.springbootsecurity.domain.User;
import com.example.springbootsecurity.service.LoginService;
import com.example.springbootsecurity.utils.JwtUtil;
import com.example.springbootsecurity.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author zhoukai
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Value("${jwtConfig.expirationTime}")
    Long expirationTime;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public ResponseResult login(User user) {
        // AuthenticationManager的authenticate方法来进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 如果认证没有通过，给出对应的提示
        if(Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        // 如果认证通过，使用userId生成jwt jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId, expirationTime);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);
        map.put("expirationTime", String.valueOf(System.currentTimeMillis() + expirationTime));
        // 把用户信息存入redis
        redisUtil.set("login:" + userId, loginUser, expirationTime);
        return new ResponseResult(200, "登录成功", map);
    }

    @Override
    public ResponseResult logout() {
        // 获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        // 删除redis中的值
        redisUtil.del("login:" + userId, String.valueOf(userId));
        return new ResponseResult(200, "注销成功");
    }
}
