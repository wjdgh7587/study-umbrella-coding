package com.template.entity.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractBaseException extends RuntimeException{

//    @Serial
//    private static final long serialVersionUID = 1L;

    public AbstractBaseException() {
        super();
    }

    public AbstractBaseException(String message){ super(message); }

    public AbstractBaseException(Throwable throwable){ super(throwable);}

    public AbstractBaseException(String errorMessage, Throwable throwable){ super(errorMessage, throwable);}

    public abstract HttpStatus getHttpStatus();
}
