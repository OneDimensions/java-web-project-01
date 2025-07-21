package com.onedimension.controller;

import cn.hutool.core.io.IoUtil;
import com.onedimension.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息controller
 */
@RestController
public class UserController {

    @RequestMapping("/list")
    public List<User> list() throws FileNotFoundException {
        // 1. 加载读取用户信息文件
        // 使用工具进行文件读取到集合中

        // 因为java目录和resource目录在编译之后都会放在同一个目录下
        // 所以这里可以通过类的加载器来获取resource目录下的文件输入流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        System.out.println("strings" + lines);

        // 2. 解析每行的用户信息 存放到用户信息集合中
        List<User> userList = lines.stream().map(line -> {
            String[] items = line.split(",");
            Integer id = Integer.valueOf(items[0]);
            String username = items[1];
            String password = items[2];
            String name = items[3];
            Integer age = Integer.valueOf(items[4]);
            // 将字符串转为localDateTime 参数一: 字符串 参数二: 格式。 DateTimeFormatter.ofPattern: 创建一个格式化对象
            LocalDateTime updateTime = LocalDateTime.parse(items[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();

        // 3. 返回 返回时会自动将list的元素转为json
        // RestController注解中有个responseBody的注解能将controller返回值作为响应体直接响应
        // 如果返回值是集合、对象, 那么会自动将其转为json再响应
        return userList;
    }
}
