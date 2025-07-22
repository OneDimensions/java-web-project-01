package com.onedimension.service.impl;

import com.onedimension.dao.UserDao;
import com.onedimension.pojo.User;
import com.onedimension.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * UserService的实现类
 * service: 业务层 主要用于业务逻辑的处理
 */

/**
 * Component: 容器注解
 * 1. 作用:将当前类对象存入spring的ioc容器中
 * 2. 位置:在类上
 * 控制反转, 将类的创建交给spring, 用到这个对象时再由spring注入
 */
// @Component
@Service // 专用于service层的注解
public class UserServiceImpl2 implements UserService {

    // 依赖注入: 应用程序运行时, 会自动查询该类型的bean对象, 并赋值给成员变量
    // 依赖注入 方式一: 属性注入
    // @Autowired
    // private final UserDao userDao;


    // 方式二: 构造器注入
    private final UserDao userDao;
    // @Autowired 当类中的构造函数只有一个时, 可以省略@Autowired
    public UserServiceImpl2(UserDao userDao) {
        this.userDao = userDao;
    }

    // 方式三: setter注入
    // private UserDao userDao;
    // @Autowired
    // public void setUserDao(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    @Override
    public List<User> list() {
        // 调用dao 获取用户数据
        ArrayList<String> lines = userDao.list();

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
            return new User(id + 200, username, password, name, age, updateTime);
        }).toList();

        return userList;
    }

}
