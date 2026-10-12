package com.yan.expense.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个接口：验证「浏览器 → Spring Boot → JSON」这条链路是通的。
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("message", "后端跑起来了，权哥！");
        res.put("app", "expense");
        return res;
    }
}
