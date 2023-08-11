package com.jeongho.template.entity.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractBaseException extends RuntimeException {

    public AbstractBaseException() {
    }

    public AbstractBaseException(String message) {
        super(message);
    }

    public AbstractBaseException(Throwable e) {
        super(e);
    }

    public AbstractBaseException(String errorMessage, Throwable e) {
        super(errorMessage, e);
    }

    public abstract HttpStatus getHttpStatus();

}
