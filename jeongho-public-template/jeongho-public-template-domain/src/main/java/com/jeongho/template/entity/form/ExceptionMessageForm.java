//package com.jeongho.template.entity.form;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import io.swagger.v3.oas.annotations.media.Schema;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//
//import java.util.Arrays;
//import java.util.StringJoiner;
//
///**
// * This class is a simple form to build exception message easily..
// */
//@Schema(name = "Normal", description = "API Normal Message Form")
//@Getter
//@Setter
//@ToString
//@Slf4j
//public class ExceptionMessageForm {
//    @Schema(description = "Error Code")
//    private String code;
//    @Schema(description = "Error Message")
//    private String message;
//    @Schema(description = "Error Message Detail")
//    private String detail;
//    @Schema(description = "Response Time")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
//    private Data when;
//
//    public ExceptionMessageForm(){
//        this(HttpStatus.OK);
//    }
//
//    // TODO : 추상화 예외 처리를 위한 method 추가 필요
//    public ExceptionMessageForm(HttpStatus httpStatus){
//        this.when = new Data();
//    }
//
//
//    public static String makeExceptionMessage(String errorCode, String ... params){
//        StringJoiner sj = new StringJoiner(",");
//        Arrays.stream(params).forEach(msg -> sj.add(msg));
//        return errorCode + ":" + sj;
//    }
//
//}
