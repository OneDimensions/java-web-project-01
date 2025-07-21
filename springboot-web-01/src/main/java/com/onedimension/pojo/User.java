package com.onedimension.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户实体类
 */
@Data
@AllArgsConstructor
public class User {
    // 实际业务中一般类型使用包装类
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;
}
