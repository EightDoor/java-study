package com.example.springbootsecurity.handler;

import com.alibaba.fastjson.JSON;
import com.example.springbootsecurity.domain.ResponseResult;
import com.example.springbootsecurity.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhoukai
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用户认证失败请重新登录");
        String s = JSON.toJSONString(result);
        // 处理异常
        WebUtil.renderString(response, s);
    }
}
