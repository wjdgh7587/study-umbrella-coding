package com.jeongho.template.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeongho.template.entity.enums.BaseResultResCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;


/**
 *
 * @param <T>
 */

@Schema(description = "Common Response class")
@Data
public class ResultMessage<T> {

//    private BaseResultResCode code;
    private String code;
    private String codeDetail;
    private String message;
    private T payload;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private Date when;

    public ResultMessage() {
        this.when = new Date();
    }

    public ResultMessage(T payload, String code){
        this.when = new Date();
        this.payload = payload;
        this.codeDetail = BaseResultResCode.get(code).getKoMsg();
    }


}


