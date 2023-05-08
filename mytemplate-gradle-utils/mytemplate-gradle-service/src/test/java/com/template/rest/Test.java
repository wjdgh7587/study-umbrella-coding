package com.template.rest;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;

import java.security.Key;
import java.util.Base64;
import java.util.Map;

// Spring Boot Test
//@SpringBootTest(classes = JwtTest.class)
// Spring Boot Test @Value injection
@ActiveProfiles(profiles = "test")
@Slf4j
public class Test {

    @Value("${jwt-test.jwt.auth.name}")
    private String authName;

    private void printToken(String token){

        log.info(token);

        String[] tokens = token.split("\\.");
        log.info("Header : {}", new String(Base64.getDecoder().decode(tokens[0])));
        log.info("Body   : {}", new String(Base64.getDecoder().decode(tokens[1])));
    }

    @DisplayName("1. jjwt 활용한 Token Generator Test")
    @org.junit.jupiter.api.Test
    void jwtTest_1(){

        // Random Key
        String base64EncodedKey = "423F4528482B4D6251655468576D5A7134743777397A24432646294A404E6352";
        String name = "JJeongho";
        String testRole = "admin";

    }

    @DisplayName("2. java-jwt Token Test")
    @org.junit.jupiter.api.Test
    void jswTest_2(){

        // Random Key
        String base64EncodedKey = "423F4528482B4D6251655468576D5A7134743777397A24432646294A404E6352";
        String name = "JJeongho";
        String testRole = "admin";

    }

    @DisplayName("1-1. jjwt Auth Token Generator")
    @org.junit.jupiter.api.Test
    void jswTest_1_1(){

        log.info("-- jjwt token generator Test -- ");


    }
}
