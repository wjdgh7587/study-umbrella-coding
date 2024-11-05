package com.template.entity.results;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResultMessage<T> {

    // 응답코드
    private String resultCode;
    // 응답메세지
    private String resultMessage;
    // 응답 데이터
    private T payload;
    // 응답 시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'ㅣ' HH:mm:ss")
    private Date when;

    public ResultMessage(){
        this.when = new Date();
    }

    public ResultMessage(T payload){
        this.when = new Date();
        this.payload = payload;
    }

}
