package com.onedimension;

import com.onedimension.mapper.UserMapper;
import com.onedimension.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // springboot单元测试的注解, 会自动启动springboot的环境, 创建ioc容器
class SpringbootMybatisQuickstartApplicationTests {

    // 将userMapper对象自动注入
    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserListTest() {
        // 查询所有用户
        List<User> userList = userMapper.getUserList();
        userList.forEach(System.out::println);
    }

    @Test
    void deleteUserTest() {
        // 删除用户
        int rows = userMapper.deleteUserById(50);
        System.out.println("删除成功" + rows);
    }

    @Test
    void insertUserTest() {
        // 插入用户
        User user = new User(null, "zhangsan", "123456", "张三", 20);
        int rows = userMapper.insertUser(user);
        System.out.println("插入成功" + rows);
    }

    @Test
    void updateUserTest() {
        // 更新用户
        int rows = userMapper.updateUser(new User(1, "lisi", "123456", "李四", 20));
        System.out.println("更新成功" + rows);
    }

    @Test
    void getUserByNameTest() {
        // 查询用户
        User user = userMapper.getUserByNameAndPwd("lisi", "123456");
        System.out.println(user);
    }
}
