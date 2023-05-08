package com.template.entity.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.StringJoiner;

@Slf4j
@Getter
@Setter
@ToString
public class ExceptionMessage {

    // Error Code
    private String code;
    // Error Message
    private String message;
    // Error Details
    private String details;
    // Error response time
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd | HH:mm:ss", timezone = "Asia/Seoul")
    private Date when;


    // 생성자를 이용한 표현식
    public ExceptionMessage(){
        this(HttpStatus.OK);
    }

    public ExceptionMessage(HttpStatus httpStatus) {
        this.when = new Date();
    }


    // TODO 각각의 ErrorCode Builder 성능체크
    public static String makeExceptionMessage(String code, String ... params){

        StringJoiner stringJoiner = new StringJoiner(",");
        Arrays.stream(params).forEach(stringJoiner::add);

        return code + ":" + stringJoiner;
    }

    public static String makeBufferExceptionMessage(String errorCode, String ... params){

        StringBuffer sb = new StringBuffer();

        sb.append(errorCode).append(":");

        for(int i = 0; i < params.length; i++){
            sb.append(params[i]);
            if(i < params.length - 1){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String makeBuilderExceptionMessage(String errorCode, String ... params){

        StringBuilder sb = new StringBuilder();

        sb.append(errorCode).append(":");

        for(int i = 0; i < params.length; i++){
            sb.append(params[i]);
            if(i < params.length - 1){
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
