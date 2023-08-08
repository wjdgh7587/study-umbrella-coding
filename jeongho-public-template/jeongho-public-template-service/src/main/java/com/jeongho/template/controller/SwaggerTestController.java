package com.jeongho.template.controller;

import com.jeongho.template.entity.SwaggerTestModelB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class SwaggerTestController {

    /**
     * Swagger openapi-docs 사용시에는 다음과 같이 처리함
     *
     *
     */

    /**
     * Spring Swagger api-docs test
     * @return
     */
    @PostMapping("/test/swaggerA")
    public Map<String, Object> testSwaggerA(String testParamA, Integer testParamB){

        log.info("This is Swagger Test!!");
        log.info("Checking Parma A : P{} ", testParamA);
        log.info("Checking Parma B : P{} ", testParamB);

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("paramA", testParamA);
        resultMap.put("paramB", testParamB);

        return resultMap;
    }

    @PostMapping("/test/swaggerB")
    public SwaggerTestModelB testSwaggerB(SwaggerTestModelB param){

        log.info("This is Swagger Test!!");
        log.info("Checking Parma A : P{} ", param.getTestA());
        log.info("Checking Parma B : P{} ", param.getTestB());

        Map<String, Object> resultMap = new HashMap<>();

        return param;
    }

}
