package com.springsecuritycourse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.access.intercept.RunAsManagerImpl;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * Created by Dégi János on 2018.02.27..
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    /*
    * Scenario: you have to generate a report but your authenticated user
    * has no permission to data which used by generating a report.
    * In this case with this special RunAS functionality you can define a user
    * with the particular permissions to run only this function ("generating a report")
    *
    * */
    @Override
    protected RunAsManager runAsManager() {
        final RunAsManagerImpl runAsManager = new RunAsManagerImpl();
        runAsManager.setKey("MyRunAsKey");
        return runAsManager;
    }

}
