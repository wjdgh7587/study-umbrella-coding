package com.jeongho.template.exception;

import com.jeongho.template.entity.enums.BaseResultErrorCode;
import com.jeongho.template.entity.enums.BaseResultResCode;
import com.jeongho.template.entity.exception.InvalidRequestException;
import com.jeongho.template.entity.exception.NotFoundException;
import com.jeongho.template.entity.exception.OperationException;
import com.jeongho.template.entity.exception.UnknownException;
import com.jeongho.template.entity.form.ExceptionMessage;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class AbstractBaseException {

    private final MessageSource messageSource;

    public AbstractBaseException(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionMessage> notFoundException(
            HttpServletRequest request, final Exception exception
    ){
        log.error("Exception : {}", exception.getMessage());

        NotFoundException notFoundException = new NotFoundException(exception.getMessage(), exception);

        ExceptionMessage response = new ExceptionMessage(notFoundException);
        response.setCode(BaseResultResCode.RS_4000.getCode());
        response.setMessage(BaseResultResCode.RS_4000.getKoMsg());
        response.setDetail(messageSource.getMessage(BaseResultErrorCode.BAD_REQUEST_ERROR.name(), null, LocaleContextHolder.getLocale()));

        return new ResponseEntity<>(response, notFoundException.getHttpStatus());
    }


    // 400 error
    @ExceptionHandler(OperationException.class)
    public ResponseEntity<ExceptionMessage> operationException(
            HttpServletRequest request, final OperationException exception
    ) {

        log.error("OperationException : {}", exception.getMessage());

        ExceptionMessage response = new ExceptionMessage(exception);

        String code = exception.getCode();

        if (!StringUtils.isEmpty(code)) {
            response.setCode(BaseResultResCode.get(code).getCode());
            response.setMessage(BaseResultResCode.get(code).getKoMsg());
            response.setMessage(BaseResultResCode.get(code).getEnMsg());
        } else {
            response.setCode(BaseResultResCode.RS_4003.getCode());
            response.setMessage(BaseResultResCode.RS_4003.getKoMsg());
            response.setMessage(BaseResultResCode.RS_4003.getEnMsg());
        }

        String[] message = null;
        String msgKey = null;
        String[] params = null;

        if (!StringUtils.isEmpty(exception.getMessage())) {
            message = exception.getMessage().split(":");
            msgKey = message[0];
            params = (message.length > 1) ? message[1].split(",") : null;

//            BaseResultErrorCode.get(msgKey)
//            message.length > 1
            if (!StringUtils.isEmpty(msgKey) && BaseResultErrorCode.get(msgKey) != null) {
                response.setDetail(messageSource.getMessage(msgKey, params, LocaleContextHolder.getLocale()));
            } else {
                response.setDetail(messageSource.getMessage(BaseResultErrorCode.get(msgKey).name(), null, LocaleContextHolder.getLocale()));
            }
        } else {
            response.setDetail(messageSource.getMessage(BaseResultErrorCode.OPERATION_ERROR.name(), null, LocaleContextHolder.getLocale()));
        }

        log.error("Response Exception : {}", response);

        return new ResponseEntity<>(response, exception.getHttpStatus());
    }

    // 400 error
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ExceptionMessage> invalidRequestException(
            HttpServletRequest request, final InvalidRequestException exception
    ) {

        log.error("InvalidRequestException : {}", exception.getMessage());

        ExceptionMessage response = new ExceptionMessage(exception);

        String code = exception.getCode();

        if (!StringUtils.isEmpty(code)) {
            response.setCode(BaseResultResCode.get(code).getCode());
            response.setMessage(BaseResultResCode.get(code).getKoMsg());
            response.setMessage(BaseResultResCode.get(code).getEnMsg());
        } else {
            response.setCode(BaseResultResCode.RS_4003.getCode());
            response.setMessage(BaseResultResCode.RS_4003.getKoMsg());
            response.setMessage(BaseResultResCode.RS_4003.getEnMsg());
        }

        String[] message = null;
        String msgKey = null;
        String[] params = null;

        if (!StringUtils.isEmpty(exception.getMessage())) {
            message = exception.getMessage().split(":");
            msgKey = message[0];
            params = (message.length > 1) ? message[1].split(",") : null;

            if (!StringUtils.isEmpty(msgKey) && BaseResultErrorCode.get(msgKey) != null) {
                response.setDetail(messageSource.getMessage(BaseResultErrorCode.get("").name(), null, LocaleContextHolder.getLocale()));
//                response.setDetail(messageSource.getMessage(msgKey, params, LocaleContextHolder.getLocale()));
            } else {
                response.setDetail(messageSource.getMessage(BaseResultErrorCode.get(msgKey).name(), null, LocaleContextHolder.getLocale()));
            }
        } else {
            response.setDetail(messageSource.getMessage(BaseResultErrorCode.BAD_REQUEST_ERROR.name(), null, LocaleContextHolder.getLocale()));
        }

        log.error("Response Exception : {}", response);

        return new ResponseEntity<>(response, exception.getHttpStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMessage> exception(
            HttpServletRequest request, final Exception exception
    ){

        log.error("Exception : {}", exception.getMessage());

        UnknownException unknownException = new UnknownException(exception.getMessage(), exception);
        ExceptionMessage response = new ExceptionMessage(unknownException);
        response.setCode(BaseResultResCode.RS_5002.getKoMsg());
        response.setDetail(BaseResultResCode.RS_5002.getKoMsg());

        try{
            response.setCode(BaseResultErrorCode.INTERNAL_SERVER_ERROR.name());
        }catch (NoSuchMessageException e){
            response.setDetail("No Message Resource");
        }

        log.error("Response Exception : {}", response);

        return new ResponseEntity<>(response, unknownException.getHttpStatus());
    }

}
