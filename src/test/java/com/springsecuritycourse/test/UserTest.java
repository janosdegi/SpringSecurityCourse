package com.springsecuritycourse.test;

import com.springsecuritycourse.config.RootConfig;
import com.springsecuritycourse.domain.User;
import com.springsecuritycourse.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by Dégi János on 2017.10.12..
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from RootConfig
@WebAppConfiguration
@ContextConfiguration(classes={RootConfig.class})
public class UserTest {

    @Autowired
    IUserService userService;

    @Test
    public void userTest() {
        List<User> allUser = userService.findAll();
        for (User user: allUser) {
            System.out.println(user.getUsername());
        }
    }

}
