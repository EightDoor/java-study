package com.example.springbootsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoukai
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('system:test:list')")
    public String hello(){
        return "hello world";
    }
    @RequestMapping("/hello1")
    @PreAuthorize("@ex.hasAuthority('systeml:test')")
    public String hello1(){
        return "hello world1";
    }
    @RequestMapping("/hello2")
    public String hello2(){
        return "hello world2";
    }
}
