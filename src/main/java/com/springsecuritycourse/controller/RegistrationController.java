package com.springsecuritycourse.controller;

import com.springsecuritycourse.dao.IUserDao;
import com.springsecuritycourse.dao.IVerificationDao;
import com.springsecuritycourse.domain.User;
import com.springsecuritycourse.domain.VerificationToken;
import com.springsecuritycourse.service.IEmailService;
import com.springsecuritycourse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
public class RegistrationController {

    static Logger log = Logger.getLogger(RegistrationController.class.getName());

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserDao userDao;

    @Autowired
    IVerificationDao verificationDao;

    @Autowired
    IEmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/signup")
    public String signUp(ModelMap model) {

        List<User> userList = userService.findAll();

        log.info("--------------------------------------");
        for (User user: userList) {
            log.info(user.getUsername());
        }
        log.info("--------------------------------------");

        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST, consumes="application/json")
//    public String userRegistration(@ModelAttribute("user")User user, HttpServletRequest request) {
//    public String userRegistration(@RequestBody String json, HttpServletRequest request) {
    public String userRegistration(@RequestBody User user, HttpServletRequest request) {

        System.out.println("--------------------------------------");
        System.out.println("--------- userRegistration -----------");
        System.out.println("--------------------------------------");

        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
//
////        User user = new User("tokenuser2","tokenuser2",false);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userService.persist(user);
//        final String token = UUID.randomUUID().toString();
//
//        Calendar calendar = GregorianCalendar.getInstance();
//
//        System.out.println("--------------------------------------");
//        System.out.println(calendar.getTime().toString());
//        System.out.println("--------------------------------------");
//
//        calendar.add(Calendar.HOUR, 24);
//
//        VerificationToken vToken = new VerificationToken(token, user, calendar.getTime());
//        verificationDao.persist(vToken);
//
//        String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +
//                "/confirmRegistration?token="+token;
//        emailService.sendEmail(appUrl);


        //TODO creating a user

        return "login";
    }

    @RequestMapping(value = "/user/registration2", method = RequestMethod.POST)
    public String userRegistration2(@ModelAttribute("user")User user, HttpServletRequest request) {

        System.out.println("--------------------------------------");
        System.out.println("--------- userRegistration -----------");
        System.out.println("--------------------------------------");

        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());

//        User user = new User("tokenuser2","tokenuser2",false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.persist(user);
        final String token = UUID.randomUUID().toString();

        Calendar calendar = GregorianCalendar.getInstance();

        System.out.println("--------------------------------------");
        System.out.println(calendar.getTime().toString());
        System.out.println("--------------------------------------");

        calendar.add(Calendar.HOUR, 24);

        VerificationToken vToken = new VerificationToken(token, user, calendar.getTime());
        verificationDao.persist(vToken);

        String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +
                "/confirmRegistration?token="+token;
        emailService.sendEmail(appUrl);

//        log.info("--------------------------------------");
//        log.info(model.get("email").toString());
//        log.info(model.get("password").toString());
//        log.info(model.get("confirmpassword").toString());
//        log.info("--------------------------------------");

        //TODO creating a user

        return "login";
    }

    @RequestMapping(value = "/confirmRegistration")
    public String confirmRegistration(ModelMap model, @RequestParam String token, HttpServletRequest request) {

        log.info(" ");
        log.info("------------------confirmRegistration--------------------");
        log.info("token: " + token);

        VerificationToken vToken = verificationDao.findByField(VerificationToken.class, "token", token);

        log.info("vToken: " + vToken.getId());

        User user = vToken.getUser();

        log.info("user: " + user.getUsername());

        user.setEnabled(true);
        userDao.merge(user);
//        verificationDao.merge(vToken);
        return "login";
    }

    @RequestMapping(value = "/user/registrationtest", method = RequestMethod.POST)
    public @ResponseBody String registrationTest(@ModelAttribute("user")User user, HttpServletRequest request) {
        return "registrationTest";
    }

//    @Override
//    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
//
//        if (emailExist(accountDto.getEmail())) {
//            throw new EmailExistsException
//                    ("There is an account with that email adress: " + accountDto.getEmail());
//        }
//        User user = new User();
//
//        user.setFirstName(accountDto.getFirstName());
//        user.setLastName(accountDto.getLastName());
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//        user.setEmail(accountDto.getEmail());
//
//        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
//        return repository.save(user);
//    }

}
