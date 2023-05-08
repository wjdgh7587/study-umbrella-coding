package com.template.entity.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public abstract class AbstractBaseException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -1155074853582343433L;

    /**
     * SerialVersionUID 는 클래스를 새로 생성할때마다 새로 생성되는 것을 권장
     *
     * 이유는 클래스의 구현을 유지하기 위함
     *
     * 따라서 serialVersionUID를 명시적으로 선언하지 않아도 자동을 생성됨,
     * JVM은 OS별로 UID가 자동적으로 생성되니 명시해서 사용하는 것을 추천
     *
     * intellij - settings - inspections - Serializable class without 'serialVersionUID' -check 하기
     * */

    public AbstractBaseException() {
        super();
    }

    public AbstractBaseException(String message){ super(message); }

    public AbstractBaseException(Throwable throwable){ super(throwable);}

    public AbstractBaseException(String errorMessage, Throwable throwable){ super(errorMessage, throwable);}

    public abstract HttpStatus getHttpStatus();
}
