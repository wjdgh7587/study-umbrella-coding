package com.jeongho.template.entity.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class UnknownException extends AbstractBaseException{

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Getter
    private String code;

    public UnknownException(){
        super();
    }

    public UnknownException(String message){
        super(message);
    }

    public UnknownException(Throwable throwable){
        super(throwable);
    }

    public UnknownException(String message, Throwable throwable){
        super(message, throwable);
    }

    public UnknownException(String message, Object... args){
        super(String.format(message, args));
    }

}
