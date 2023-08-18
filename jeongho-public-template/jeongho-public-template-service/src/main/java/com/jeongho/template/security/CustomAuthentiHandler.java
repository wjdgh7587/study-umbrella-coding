package com.jeongho.template.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeongho.template.entity.enums.BaseResultErrorCode;
import com.jeongho.template.entity.enums.BaseResultResCode;
import com.jeongho.template.entity.form.ExceptionMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthentiHandler implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        ExceptionMessage payload = new ExceptionMessage();

        payload.setCode(BaseResultResCode.RS_4040.getCode());
        payload.setDetail(BaseResultResCode.RS_4040.getEnMsg());
        payload.setMessage(BaseResultErrorCode.BAD_REQUEST_ERROR.name());

//        Map<String, Object> payload = new HashMap<>();
//        payload.put("timestamp", new Date());
//        payload.put("status", HttpStatus.BAD_REQUEST.value());
//        payload.put("error", "");
//        payload.put("message", "Access is not allowed");

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());


        objectMapper.writeValue(response.getWriter(), payload);

    }
}

