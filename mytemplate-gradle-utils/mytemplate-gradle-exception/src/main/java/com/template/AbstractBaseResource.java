package com.template;

import com.sun.jdi.request.InvalidRequestStateException;
import com.template.entity.enums.ResultResCode;
import com.template.entity.exception.ExceptionMessage;
import com.template.entity.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// @ControllerAdvice 애플리케이션 내에서 예외를 일괄적으로 처리할 수 있도록 하는 annotation
@Slf4j
@ControllerAdvice(annotations = RestController.class)
@EnableAutoConfiguration
public class AbstractBaseResource {


    // MessageSource -> SpringFramework 에서 제공하는 인터페이스 중 하나, 국제화(i18n) 기능 지원
    /**
     * 1. 메세지 가져오기
     * 2. 국제화
     * 3. 메세지 포멧 -> 동적인 메세지 구성
     */
    @Autowired
    private MessageSource messageSource;

    @Value("${project.service.code}")
    private String serviceName;

    @ExceptionHandler(InvalidRequestStateException.class)
    public ResponseEntity<String> invalidRequestException(HttpServletRequest request, final InvalidRequestStateException exception){

        log.error("InvalidRequestException : {}", exception.getMessage());

        return null;
    }

    /**
     * Not Found Exception
     * @param request Https Status Value
     * @param exception Exception Object(Not Found Exception)
     * @return exceptionMessage
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessage> notFoundException(HttpStatus request, final NotFoundException exception){

        log.error("Not Found Exception : {}", exception.getMessage());

        ExceptionMessage exceptionMessage = new ExceptionMessage();

        String code = exception.getCode();

        if(code != null){
            exceptionMessage.setCode(code);
            exceptionMessage.setMessage(ResultResCode.get(code).getResultMsgKo());
        }else{
            //exceptionMessage.setCode(serviceName+ResultResCode.);
        }

        return null;
    }



}
