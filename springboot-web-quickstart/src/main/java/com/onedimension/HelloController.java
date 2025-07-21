package com.onedimension;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 该注解表示这是一个请求处理类
public class HelloController {

    @RequestMapping("/hello") // 该注解表示这是一个处理请求的方法 RequestMapping的属性为请求路径
    // 声明前端传入的参数
    public String hello(String name) {
        return "Hello Spring Boot: " + name;
    }
}
