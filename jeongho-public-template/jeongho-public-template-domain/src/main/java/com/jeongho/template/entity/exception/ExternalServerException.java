package com.jeongho.template.entity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ExternalServerException extends AbstractBaseException{
    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Getter
    private String code;

    public ExternalServerException(){
        super();
    }

    public ExternalServerException(Throwable throwable){
        super(throwable);
    }

    public ExternalServerException(String message, Throwable throwable){
        super(message, throwable);
    }

    public ExternalServerException(String message, Object... args){
        super(String.format(message, args));
    }
}
