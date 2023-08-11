package com.jeongho.template.entity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends AbstractBaseException{
    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
