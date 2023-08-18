package com.jeongho.template.entity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends AbstractBaseException {
    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Getter
    private String code;

    public InternalServerException() {
        super();
    }

    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(Throwable throwable) {
        super(throwable);
    }

    public InternalServerException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public InternalServerException(String message, Object... args) {
        super(String.format(message, args));
    }
}
