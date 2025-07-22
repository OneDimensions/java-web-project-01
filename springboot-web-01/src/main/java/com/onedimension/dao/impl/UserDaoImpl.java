package com.onedimension.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.onedimension.dao.UserDao;
import com.onedimension.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDao的实现类
 * dao: data access object
 * 主要用于数据的访问 持久层
 */

/**
 * Component: 容器注解
 * 1. 作用:将当前类对象存入spring的ioc容器中
 * 2. 位置:在类上
 * 控制反转, 将类的创建交给spring, 用到这个对象时再由spring注入
 * bean: ioc的对象, 名称为实现类的名称首字母小写
 */
// @Component
@Repository // 专用于注解dao层的注解 是Component的衍生注解
public class UserDaoImpl implements UserDao {

    @Override
    public ArrayList<String> list() {
        // 1. 加载读取用户信息文件
        // 使用工具进行文件读取到集合中

        // 因为java目录和resource目录在编译之后都会放在同一个目录下
        // 所以这里可以通过类的加载器来获取resource目录下的文件输入流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
