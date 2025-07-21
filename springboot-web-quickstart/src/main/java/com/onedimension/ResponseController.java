package com.onedimension;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class ResponseController {

    /**
     * 方式一: httpServletResponse 设置相应数据
     * @param response
     * @throws IOException
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {

        // 设置响应状态码 通常情况下不手动设置
        response.setStatus(HttpServletResponse.SC_OK);

        // 设置响应头
        response.setHeader("Content-Type", "text/html; charset=utf-8");

        // 设置响应体 通过io流响应
        PrintWriter writer = response.getWriter();
        writer.write("<h1>你好</h1>");
    }

    /**
     * 方式二: 通过spring提供的responseEntity设置响应数据
     * 接收的范型表示响应体的数据类型
     */
    public ResponseEntity<String> response2() {
        // return ResponseEntity.ok("Hello Spring Boot");
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "text/html; charset=utf-8")
                .body("<h1>你好</h1>");
    }
}
