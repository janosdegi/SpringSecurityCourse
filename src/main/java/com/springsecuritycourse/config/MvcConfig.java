package com.springsecuritycourse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
//@Import({ SecurityConfig.class })
//@ComponentScan(basePackages = {"com.springsecuritycourse.config","com.springsecuritycourse.dao",
//		"com.springsecuritycourse.controller", "com.springsecuritycourse.service"}) //beens of dispatcher-servlet context
@ComponentScan(basePackages = "com.springsecuritycourse.controller") //beens of dispatcher-servlet context
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/html/");
		viewResolver.setSuffix(".html");
		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
