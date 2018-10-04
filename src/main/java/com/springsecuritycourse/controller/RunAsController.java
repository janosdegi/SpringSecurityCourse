package com.springsecuritycourse.controller;

import com.springsecuritycourse.service.IRunAsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/runas")
public class RunAsController {

    @Autowired
    IRunAsService runAsService;

    @RequestMapping
    @ResponseBody
    @Secured({"ROLE_USER","RUN_AS_REPORTER"})
    public String tryRunAs() {
        return runAsService.runAsServiceTest();
    }


}
