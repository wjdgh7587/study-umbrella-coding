//package com.jeongho.template.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class FilterConfig implements WebMvcConfigurer {
//
//    private final ObjectMapper objectMapper;
//
//    @Bean
//    public FilterRegistrationBean   filterRegistrationBean(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(null);
//
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(){
//
//        return null;
//    }
//}
