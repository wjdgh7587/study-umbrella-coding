package com.jeongho.template.entity;

import com.jeongho.template.entity.enums.BaseResultResCode;
import com.jeongho.template.entity.exception.InvalidRequestException;
import com.jeongho.template.entity.form.ExceptionMessage;

/**
 * Entity Test
 */
public class test {

    public static void main(String[] args) {

        /* ResultMessage Case */
//        ResultMessage resultMessage = new ResultMessage();
//        resultMessage.setCode(BaseResultResCode.RS_2001.getCode());
//        resultMessage.setCodeDetail(BaseResultResCode.RS_2001.getKoMsg());
//        resultMessage.setMessage("안녕하세용!!");
//        resultMessage.setPayload("ㅋㅋㅋㅋ");
//
//        System.out.println(resultMessage);

        /* ExceptionMessage Case */

        String test = "Test";

        if(!test.equals("TesT")){
            throw new InvalidRequestException(BaseResultResCode.RS_5002.getCode(),
                    ExceptionMessage.makeExceptionMessage(BaseResultResCode.RS_5002.getName(),  "어떤 거가 이상해요"));
        }


    }

}
