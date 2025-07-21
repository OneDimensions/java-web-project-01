package com.onedimension.service;

import com.onedimension.pojo.User;

import java.util.List;

/**
 * UserService的实现类
 * service: 业务层 主要用于业务逻辑的处理
 */
public interface UserService {

    /**
     * 查询所有用户信息
     */
    public List<User> list();
}
