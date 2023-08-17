package com.jeongho.template.controller;

import com.jeongho.template.entity.SwaggerTestModelB;
import com.jeongho.template.entity.enums.BaseResultResCode;
import com.jeongho.template.entity.exception.InvalidRequestException;
import com.jeongho.template.entity.exception.NotFoundException;
import com.jeongho.template.entity.form.ExceptionMessage;
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

        log.info("This is Swagger TestA!!");
        log.info("Checking Parma A : P{} ", testParamA);
        log.info("Checking Parma B : P{} ", testParamB);

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("paramA", testParamA);
        resultMap.put("paramB", testParamB);

        return resultMap;
    }

    @PostMapping("/test/swaggerB")
    public SwaggerTestModelB testSwaggerB(SwaggerTestModelB param){

        log.info("This is Swagger TestB!!");
        log.info("This is Swagger TestB!!");
        log.info("Checking Parma A : {} ", param.getTestA());
        log.info("Checking Parma B : {} ", param.getTestB());

        Map<String, Object> resultMap = new HashMap<>();

        if(!param.getTestA().equals(param.getTestB())){
            throw new NotFoundException(BaseResultResCode.RS_4001.getCode(),
                    ExceptionMessage.makeExceptionMessage(BaseResultResCode.RS_4001.getName(), "FILE NAME"));
        }

        return param;
    }

}
