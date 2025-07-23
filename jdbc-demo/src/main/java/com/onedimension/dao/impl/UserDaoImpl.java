package com.onedimension.dao.impl;

import com.onedimension.dao.UserDao;
import com.onedimension.pojo.User;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Dotenv dotenv;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        dotenv = Dotenv.configure()
                .directory(System.getProperty("user.dir"))
                .filename(".env")
                .load();
        url = dotenv.get("DB_URL") + "/web01";
        username = dotenv.get("DB_USERNAME");
        password = dotenv.get("DB_PASSWORD");
    }


    @Override
    public User getUserById(Integer id) {
        Connection connection = null;
        Statement statement = null;
        // ResultSet: 封装当前语句查询的结果集
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            String sqlString = "SELECT id, username, password, name, age FROM user WHERE id = ?"; // 预编译sql

            // prepareStatement: 预编译
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);

            // 替换?占位符 设置参数
            preparedStatement.setInt(1, id);

            // 执行SQL 获取结果集
            resultSet = preparedStatement.executeQuery();
            User user = new User();

            // resultSet.next: 获取结果集中的下一条记录 如果有就返回true 没有就返回false
            while (resultSet.next()) {
                // 将结果集中的数据封装到user
                // resultSet.getInt: 获取指定列的值
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
            }
            statement.close();
            connection.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<User> getUserList() {
        return List.of();
    }
}
