package com.nextyu;

import com.nextyu.domain.User;
import com.nextyu.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        // 准备，清空user表
        userService.deleteAllUser();
    }

    @Test
    public void test() {
        // 插入3个用户
        userService.saveUser(new User("小明", 1));
        userService.saveUser(new User("小黑", 2));
        userService.saveUser(new User("小红", 3));

        // 查数据库，应该有3个用户
        Assert.assertEquals(3L, userService.countAllUser().longValue());
    }

}
