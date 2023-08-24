package com.jeongho.template.controller;

import com.jeongho.template.entity.SwaggerTestModelB;
import com.jeongho.template.entity.enums.BaseResultErrorCode;
import com.jeongho.template.entity.enums.BaseResultResCode;
import com.jeongho.template.entity.exception.*;
import com.jeongho.template.entity.form.ExceptionMessage;
import com.jeongho.template.entity.form.ResultMessage;
import com.jeongho.template.entity.params.TestExcel2;
import com.jeongho.template.utils.ExcelFormatUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class SwaggerTestController {

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

    @GetMapping("/test/excel/export")
    public void testSwaggerA(HttpServletResponse response) throws IOException {

        log.info("Export excel export");

        Map<String, List<?>> resultMap = new HashMap<>();
        List<String> headerList = new ArrayList<>();
        List<TestExcel2> test2 = new ArrayList<>();

        headerList.add("name");
        headerList.add("gender");
        headerList.add("age");

        TestExcel2 tt = new TestExcel2();
        tt.setOrder(2);
        tt.setName("정호");
        tt.setGender("Male");
        test2.add(tt);

        resultMap.put("header", headerList);
        resultMap.put("body", test2);

        ExcelFormatUtil.exportObjectToExcel(response, resultMap);
    }

    @PostMapping("/test/swaggerB")
    public ResultMessage testSwaggerB(@RequestBody SwaggerTestModelB param) throws Exception {

        log.info("This is Swagger TestB!!");
        log.info("This is Swagger TestB!!");
        log.info("Checking Parma A : {} ", param.getTestA());
        log.info("Checking Parma B : {} ", param.getTestB());

        Map<String, Object> resultMap = new HashMap<>();
        ResultMessage resultMessage = new ResultMessage();

        // InvalidRequestException
//        if(!param.getTestA().equals(param.getTestB())){
//            throw new InvalidRequestException(BaseResultResCode.RS_4003.getCode(),
//                    ExceptionMessage.makeExceptionMessage(BaseResultResCode.RS_4003.getName(), "FILE NAME"));
//        }

        // InvalidRequestException USER_NOT_FOUND
//        if(!param.getTestA().equals(param.getTestB())){
//            throw new OperationException(BaseResultResCode.RS_4002.getCode(),
//                    ExceptionMessage.makeExceptionMessage(BaseResultErrorCode.USER_NOT_FOUND.name(), "윤정호"));
//        }

        // RequestException USER_NOT_FOUND
//        if(!param.getTestA().equals(param.getTestB())){
//            throw new InternalServerException(BaseResultResCode.RS_5002.getCode(),
//                    ExceptionMessage.makeExceptionMessage(BaseResultErrorCode.INTERNAL_SERVER_ERROR.name(), "Testing"));
//        }

        if(!param.getTestA().equals(param.getTestB())) {
            //1 normal throw
//            throw new NotFoundException("testst");
            //2 exception throw
            throw new NotFoundException(BaseResultResCode.RS_5002.getCode(),
            ExceptionMessage.makeExceptionMessage(BaseResultErrorCode.BAD_REQUEST_ERROR.name(), "test"));
//            throw new NotFoundException("test");
        }

        else{
            resultMessage.setCode(BaseResultResCode.RS_2001.getCode());
            resultMessage.setCodeDetail(BaseResultResCode.RS_2001.getKoMsg());
            resultMessage.setMessage("안녕하세용!!");
            resultMessage.setPayload(param);
        }

        return resultMessage;
    }

}
