package com.onedimension.mapper;

import com.onedimension.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // mybatis的注解 应用程序运行时, 会自动的为该接口创建一个(实现类对象)代理对象, 并将该代理对象注入到spring的ioc容器中
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    // @Select("select id, username, password, name, age from user") // select: 查询语句注解
    // 查询出的结果会自动封装到User对象中
    // 已经在UserMapper.xml中配置了查询语句, 所以这里不写
    // 复杂的sql建议使用xml
    public List<User> getUserList();

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    @Delete("delete from user where id = #{id}") // delete: 删除语句注解 预编译sql 使用占位符替换参数
    public Integer deleteUserById(Integer id);

    /**
     * 插入用户
     *
     * @param user 用户
     */
    @Insert("insert into user(username, password, name, age) values (#{username}, #{password}, #{name}, #{age})")
    public Integer insertUser(User user);

    /**
     * 更新用户
     *
     * @param user 用户
     */
    @Update("update user set username=#{username}, password=#{password}, name=#{name}, age=#{age} where id = #{id}")
    public Integer updateUser(User user);

    /**
     * 根据用户名密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return user 用户
     */
    @Select("select id, username, password, name, age from user where username=#{username} and password=#{password}")
    // 编译成字节码之后形参名会消失, 如果方法传入的是多个形参, 需要用@Param注解来指定参数名
    // public User getUserByNameAndPwd(@Param("username") String username, @Param("password") String password);
    // 基于springboot官方脚手架创建的项目, 接口编译时会保留方法形参(通过springboot-parent依赖的maven插件实现), 所以可以省略@Param注解
    public User getUserByNameAndPwd(String username, String password);
}
