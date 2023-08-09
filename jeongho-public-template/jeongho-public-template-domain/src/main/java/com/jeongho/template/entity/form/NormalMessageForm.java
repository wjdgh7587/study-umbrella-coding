package com.jeongho.template.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Arrays;
import java.util.StringJoiner;

@Schema(name = "Normal", description = "API Normal Message Form")
public class NormalMessageForm {
    @Schema(description = "Normal Code")
    private String code;
    @Schema(description = "Normal Message")
    private String message;
    @Schema(description = "Normal Message Detail")
    private String detail;
    @Schema(description = "Response Time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private Data when;

    public static String buildNormalMessage(String errorCode, String ... params){
        StringJoiner sj = new StringJoiner(",");
        Arrays.stream(params).forEach(msg -> sj.add(msg));
        return errorCode + ":" + sj;
    }

}
