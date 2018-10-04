package com.springsecuritycourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathController {

    @RequestMapping(value = "/login")
    public String login(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "login";
    }

    @RequestMapping(value = "/welcome")
    public String loggedin(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "welcome";
    }

    @RequestMapping(value = "/secured")
    public String getSecured(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "secured";
    }
}
