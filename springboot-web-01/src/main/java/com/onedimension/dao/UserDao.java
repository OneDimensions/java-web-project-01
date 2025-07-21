package com.onedimension.dao;

import java.util.ArrayList;

/**
 * dao: data access object
 * 主要用于数据的访问 持久层
 */
public interface UserDao {
    /**
     * 加载用户数据
     * @return 用户数据
     */
    public ArrayList<String> list();
}
