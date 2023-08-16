package com.jeongho.template.entity.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class OperationException extends AbstractBaseException{

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Getter
    private String code;

    public OperationException(){
        super();
    }

    public OperationException(Throwable throwable){
        super(throwable);
    }

    public OperationException(String message, Throwable throwable){
        super(message, throwable);
    }

    public OperationException(String message, Object... args){
        super(String.format(message, args));
    }

}
