package com.onedimension;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 测试类
 * DisplayName: 自定义测试类或者方法的名称
 */
@DisplayName("测试用户服务类")
public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    // 每次测试方法执行前初始化
    public void setUp() {
        this.userService = new UserService();
    }

    @Test
    public void testGetAge() {
        Integer age = userService.getAge("450321199807211011");
        System.out.println(age);
    }

    @Test
    public void testGetGender() {
        String gender = userService.getGender("450321199807211011");
        System.out.println(gender);
    }

    @Test
    public void testGetAgeWithAssert() {
        String gender = userService.getGender("450321199807211011");
        // 断言
        Assertions.assertEquals("男", gender);
    }

    @Test
    public void testGetGenderWithAssertException() {
        // 参数一: 期望抛出的异常类型
        // 参数二: 运行函数 getGender内部抛出了一个IllegalArgumentException的异常
        // 看运行的异常与期望的异常是否一致
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        });
    }

    // @BeforeEach // 每个测试方法执行前执行 用于初始化
    // public void beforeEach() {
    //     System.out.println("beforeEach");
    // }
    //
    // @AfterEach // 每个测试方法执行后执行 用于清理 资源释放
    // public void afterEach() {
    //     System.out.println("afterEach");
    // }
    //
    // @BeforeAll // 所有测试方法执行前执行一次 只能修饰static 用于初始化
    // public static void beforeAll() {
    //     System.out.println("beforeAll");
    // }
    //
    // @AfterAll
    // public static void afterAll() { // 所有测试方法执行后执行一次 只能修饰static 用于清理 资源释放
    //     System.out.println("afterAll");
    // }

    /**
     * 参数化测试
     * 多次执行同一个测试方法
     * 参数化的值来自ValueSource
     */
    @ParameterizedTest
    @ValueSource(strings = {"450321199807211011", "450321199807211032", "450321199807211053"})
    @DisplayName("给定一个身份证号, 计算出该用户的性别")
    public void testGetAge(String idCard) {
        String gender = userService.getGender(idCard);
        Assertions.assertEquals("男", gender);
    }
}
