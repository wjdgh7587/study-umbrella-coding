package com.jeongho.template.entity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends AbstractBaseException{

    private static final long serialVersionUID = 1L;

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    @Getter
    private String code;

    public InvalidRequestException(){
        super();
    }

    public InvalidRequestException(Throwable e){
        super(e);
    }

    public InvalidRequestException(String message, Throwable e){
        super(message, e);
    }

    public InvalidRequestException(String message, Object... args){
        super(String.format(message, args));
    }
}
