package com.jeongho.template.entity;

import com.jeongho.template.entity.form.ResultMessage;

/**
 * Entity Test
 */
public class test {

    public static void main(String[] args) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setMessage("안녕하세용!!");
        resultMessage.setPayload("ㅋㅋㅋㅋ");

        System.out.println(resultMessage);

    }
}
