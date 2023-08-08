package com.jeongho.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 만약 spring boot 가 제공하는 web mvc 기본 설정 없이 모두 설정을 하려면
     * @EnableWebMvc 을 선언하면 되고
     * 기본 MVC 설정을 유지하면서 사용하려면 @Configuration + implements WebMvcConfigurer
     * 을 같이 사용하면 된다.
     *
     * @param registry
     */

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods(
                        HttpMethod.GET.name()
                        , HttpMethod.POST.name()
                        , HttpMethod.PUT.name()
                        , HttpMethod.DELETE.name()
                        /*, HttpMethod.OPTIONS.name()*/
                )
                .maxAge(3600);
    }
}
