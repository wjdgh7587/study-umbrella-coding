package com.jeongho.template.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeongho.template.entity.enums.BaseResultErrorCode;
import com.jeongho.template.entity.enums.BaseResultResCode;
import com.jeongho.template.entity.form.ExceptionMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomAuthenticationHandler implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        ExceptionMessage payload = new ExceptionMessage();

        payload.setCode(BaseResultResCode.RS_4040.getCode());
        payload.setDetail(BaseResultResCode.RS_4040.getEnMsg());
        payload.setMessage(BaseResultErrorCode.BAD_REQUEST_ERROR.name());

        // Normal
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

