package com.jeongho.template.exception;

import com.jeongho.template.entity.enums.BaseResultErrorCode;
import com.jeongho.template.entity.enums.BaseResultResCode;
import com.jeongho.template.entity.exception.InvalidRequestException;
import com.jeongho.template.entity.exception.NotFoundException;
import com.jeongho.template.entity.form.ExceptionMessage;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class AbstractBaseException {

    private final MessageSource messageSource;

    public AbstractBaseException(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // 400 Error
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ExceptionMessage> invalidRequestException(
            HttpServletRequest request, final InvalidRequestException exception
    ){

        log.error("InvalidRequestException : {}", exception.getMessage());

        ExceptionMessage response = new ExceptionMessage(exception);

        String code = exception.getCode();

        if(!StringUtils.isEmpty(code)) {
            response.setCode(BaseResultResCode.get(code).getCode());
            response.setMessage(BaseResultResCode.get(code).getKoMsg());
            response.setMessage(BaseResultResCode.get(code).getEnMsg());
        }
        else {
            response.setCode(BaseResultResCode.RS_4003.getCode());
            response.setMessage(BaseResultResCode.RS_4003.getKoMsg());
            response.setMessage(BaseResultResCode.RS_4003.getEnMsg());
        }

        String[] message = null;
        String msgKey = null;
        String[] params = null;

        if(!StringUtils.isEmpty(exception.getMessage())){
            message = exception.getMessage().split(":");
            msgKey = message[0];
            params = (message.length > 1) ? message[1].split(",") : null;

            if(!StringUtils.isEmpty(msgKey) && message.length > 1){
                response.setDetail(messageSource.getMessage(msgKey, params, LocaleContextHolder.getLocale()));
            }else{
                response.setDetail(messageSource.getMessage(BaseResultResCode.get(code).getName(), null, LocaleContextHolder.getLocale()));
            }
        }else{
            response.setDetail(messageSource.getMessage(BaseResultResCode.get(code).getName(), null, LocaleContextHolder.getLocale()));
        }

        log.error("Response Exception : {}", response);

        return new ResponseEntity<>(response, exception.getHttpStatus());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessage> notFoundException(
            HttpServletRequest request, final NotFoundException exception
    ){

        log.error("NotFoundException : {}", exception.getMessage());

        ExceptionMessage response = new ExceptionMessage(exception);

        String code = exception.getCode();

        if(!StringUtils.isEmpty(code)) {
            response.setCode(BaseResultResCode.get(code).getCode());
            response.setMessage(BaseResultResCode.get(code).getKoMsg());
//            response.setMessage(BaseResultResCode.get(code).getEnMsg());
        }
        else {
            response.setCode(BaseResultResCode.RS_4003.getCode());
            response.setMessage(BaseResultResCode.RS_4003.getKoMsg());
//            response.setMessage(BaseResultResCode.RS_4003.getEnMsg());
        }

        String[] message = null;
        String msgKey = null;
        String[] params = null;

        if(!StringUtils.isEmpty(exception.getMessage())){
            message = exception.getMessage().split(":");
            msgKey = message[0];
            params = (message.length > 1) ? message[1].split(",") : null;

            BaseResultErrorCode test = BaseResultErrorCode.get(msgKey);

            if(!StringUtils.isEmpty(msgKey) && BaseResultErrorCode.get(msgKey) != null){
                response.setDetail(messageSource.getMessage(msgKey, params, LocaleContextHolder.getLocale()));
            }else{
                response.setDetail(messageSource.getMessage(BaseResultErrorCode.RESOURCE_NOT_FOUND.name(), null, LocaleContextHolder.getLocale()));
            }
        }else{
            response.setDetail(messageSource.getMessage(BaseResultErrorCode.RESOURCE_NOT_FOUND.name(), null, LocaleContextHolder.getLocale()));
        }

        log.error("Response Exception : {}", response);

        return new ResponseEntity<>(response, exception.getHttpStatus());
    }


}
