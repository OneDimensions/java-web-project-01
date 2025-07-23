package com.onedimension.dao;

import com.onedimension.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    User getUserById(Integer id) throws SQLException;

    List<User> getUserList();
}
