package com.jeongho.template.entity.exception;

import com.jeongho.template.entity.enums.BaseResultResCode;
import org.springframework.http.HttpStatus;

public abstract class AbstractBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected String code;

    public AbstractBaseException() {
        super();
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
