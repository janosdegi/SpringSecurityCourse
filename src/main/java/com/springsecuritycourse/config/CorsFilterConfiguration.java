//package com.springsecuritycourse.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import javax.servlet.FilterRegistration;
//
///**
// * Created by Dégi János on 2018.01.19..
// */
//@Configuration
//public class CorsFilterConfiguration {
//
//    @Bean
//    public FilterRegistration corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://domain1.com");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistration bean = new FilterRegistration(new CorsFilter(source));
//        bean.setOrder(0);
//        return bean;
//    }
//}
