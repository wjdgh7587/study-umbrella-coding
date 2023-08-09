package com.jeongho.template.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.StringJoiner;

@Schema(name = "Error", description = "API Error Message Form")
@Getter
@Setter
@ToString
@Slf4j
public class ErrorMessageForm {
    @Schema(description = "Error Code")
    private String code;
    @Schema(description = "Error Message")
    private String message;
    @Schema(description = "Error Message Detail")
    private String detail;
    @Schema(description = "Response Time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private Data when;

    public static String buildErrorMessage(String errorCode, String ... params){
        StringJoiner sj = new StringJoiner(",");
        Arrays.stream(params).forEach(msg -> sj.add(msg));
        return errorCode + ":" + sj;
    }

}
