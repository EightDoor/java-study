package com.start6.demothread.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周凯
 * @date 2022/10/23
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping
    public String hello() {
        return "hello";
    }
}
