package com.template.entity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends AbstractBaseException{

    @Getter
    private String code;

    public NotFoundException(){
        super();
    }

    public NotFoundException(Throwable throwable){
        super(throwable);
    }

    public NotFoundException(String code, String message){
        super();
        this.code = code;
    }

    public NotFoundException(String message, Object... args){
        super(String.format(message, args));
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

}
