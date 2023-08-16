package com.jeongho.template.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeongho.template.entity.exception.AbstractBaseException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.StringJoiner;

/**
 * This class is a simple form to build exception message easily..
 */
@Schema(name = "Normal", description = "API Normal Message Form")
@Getter
@Setter
@ToString
@Slf4j
public class ExceptionMessage {
    @Schema(description = "Error Code")
    private String code;
    @Schema(description = "Error Message")
    private String message;
    @Schema(description = "Error Message Detail")
    private String detail;
    @Schema(description = "Response Time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private Date when;

    public ExceptionMessage(){
        this(HttpStatus.OK);
    }

    public ExceptionMessage(HttpStatus httpStatus){
        this.when = new Date();
    }

    public ExceptionMessage(AbstractBaseException ex){
        HttpStatus httpStatus = ex.getHttpStatus();
        this.detail = ex.getMessage();
        this.when = new Date();
    }


    public static String makeExceptionMessage(String errorCode, String ... params){
        StringJoiner sj = new StringJoiner(",");
        Arrays.stream(params).forEach(msg -> sj.add(msg));
        return errorCode + ":" + sj;
    }

}
