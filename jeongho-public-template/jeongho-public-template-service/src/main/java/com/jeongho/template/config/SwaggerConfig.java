package com.jeongho.template.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){

        // Swagger info
        /**
         * @Value Annotation 으로 활용 가능
         */
        Info info = new Info()
                .version("v1.0.0")
                .title("Jeongho Swagger Title")
                .description("This is testing swagger description");

        return new OpenAPI()
                .info(info);

    }

    /**
     * Swagger JWT 구성
     * Spring security 필요
     * @return
     */

}
