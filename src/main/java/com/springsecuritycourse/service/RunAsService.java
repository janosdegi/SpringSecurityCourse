package com.springsecuritycourse.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * Created by Dégi János on 2018.02.27..
 */
@Service
public class RunAsService implements IRunAsService {

    @Secured("ROLE_RUN_AS_REPORTER")
    public String runAsServiceTest() {
        return "runAsServiceTest";
    }

}
