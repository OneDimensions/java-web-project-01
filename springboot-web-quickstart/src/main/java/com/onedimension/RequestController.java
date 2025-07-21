package com.onedimension;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping("/request")
    // HttpServletRequest: 可以获取请求的信息
    public String handleRequest(HttpServletRequest request) {
        // 1. 获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式 = " + method);

        // 2. 获取请求路径url
        String url = request.getRequestURL().toString(); // http://localhost:8080/request 完整的请求路径
        System.out.println("完整请求路径url  = " + url);
        String uri = request.getRequestURI(); // /request
        System.out.println("请求路径uri  = " + uri);

        // 3. 获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议 = " + protocol);

        // 4. 获取请求参数
        String name = request.getParameter( "name" );
        System.out.println("请求参数name = " + name);

        // 5. 获取请求头
        String accept = request.getHeader("accept");
        System.out.println("请求头accept = " + accept);

        return "success";
    }
}
