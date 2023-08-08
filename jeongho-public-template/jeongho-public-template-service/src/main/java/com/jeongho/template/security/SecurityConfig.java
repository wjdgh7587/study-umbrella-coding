package com.jeongho.template.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
        http.cors().disable().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher(authRequest, swaggerRequest))
                .permitAll();

        return http.build();
    }

    /**
     * 허용되지 않는 access 접근시 메세지
     * @return
     */
    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return null;
    }
}
