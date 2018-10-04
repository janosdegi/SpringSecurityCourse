package com.springsecuritycourse.test;

import com.springsecuritycourse.config.RootConfig;
import com.springsecuritycourse.dao.IVerificationDao;
import com.springsecuritycourse.domain.User;
import com.springsecuritycourse.domain.VerificationToken;
import com.springsecuritycourse.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;

/**
 * Created by Dégi János on 2017.10.12..
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from RootConfig
@WebAppConfiguration
@ContextConfiguration(classes={RootConfig.class})
public class VerificationTokenTest {

    @Autowired
    IVerificationDao verificationDao;

    @Autowired
    IUserService userService;


    @Test
    public void findByTest() {

//        VerificationToken vToken = verificationDao.findByToken("3bdd70f8-d8cc-40ca-b79e-76cd3bda4bc3");

        VerificationToken vToken = verificationDao.
                findByField(VerificationToken.class, "token", "3bdd70f8-d8cc-40ca-b79e-76cd3bda4bc3");

        System.out.println("--------------------------------------");
        System.out.println(vToken.getId());
        System.out.println("--------------------------------------");

    }

//    @Test
    public void createTokenTest() {
        User user = new User("tokenuser","tokenuser",false);
        userService.persist(user);
        final String token = UUID.randomUUID().toString();

        Calendar calendar = GregorianCalendar.getInstance();

        System.out.println("--------------------------------------");
        System.out.println(calendar.getTime().toString());
        System.out.println("--------------------------------------");

        calendar.add(Calendar.HOUR, 24);

        VerificationToken vToken = new VerificationToken(token, user, calendar.getTime());
        verificationDao.persist(vToken);
    }



    //    @Test
    public void calendarTest() {
        Calendar calendar = GregorianCalendar.getInstance();
        System.out.println("--------------------------------------");
        System.out.println(calendar.getTime().toString());
        System.out.println("--------------------------------------");

        calendar.add(Calendar.HOUR, 24);

        Date date = new Date();

        System.out.println("--------------------------------------");
        System.out.println(calendar.getTime().toString());
        System.out.println("--------------------------------------");


    }

}
