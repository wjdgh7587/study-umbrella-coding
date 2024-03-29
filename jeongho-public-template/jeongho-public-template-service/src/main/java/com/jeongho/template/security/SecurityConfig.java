package com.jeongho.template.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
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

    @Value("${security.auth_api_docs}")
    private String authApiDocs;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        /**
         * 기본적으로 Rest ->
         * httpBasic() disable()
         * , csrf() disable() 처리함
         * , swagger 한정 허용
         */

        http.httpBasic().disable()
                .cors().disable()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher(swaggerRequest)
                        , new AntPathRequestMatcher(authApiDocs)
                        , new AntPathRequestMatcher(authRequest)
                )
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(authenticationEntryPoint())
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

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new CustomAuthenticationHandler();
    }

}