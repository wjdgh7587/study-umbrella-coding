package com.jeongho.template.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    /**
     *  application.yml 에서 security.auth-request 항목 수정하여
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Value("${security.auth_request}")
    private String authRequest;

    @Value("${security.auth_swagger}")
    private String swaggerRequest;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic().disable()// rest 기본 설정 사용 X
                .cors().and()
                .csrf().disable() // rest csrf 보안 필요 X
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/**"))
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
        ;

        http.authorizeHttpRequests().requestMatchers(HttpMethod.OPTIONS).permitAll();

        return http.build();
    }

    /**
     * 허용되지 않는 access 접근시 세팅하는 메세지
     * @return
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler(){

        // 잘못된 페이지로 접근하면 accessDeniedHandler 에 설정되어 있는 페이지로 안내
//        AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
//        accessDeniedHandler.setErrorPage("/page");

        return new CustomAccessDeniedHandler();
//        return accessDeniedHandler();
    }

}