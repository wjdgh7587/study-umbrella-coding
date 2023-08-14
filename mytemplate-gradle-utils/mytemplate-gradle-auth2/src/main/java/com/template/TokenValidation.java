package com.template;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenValidation {


    // Token Validation 테스트
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJ0ZXN0X3l1biIsImlhdCI6MTY4NTQ0NjUxNCwiZXhwIjoxNjg1NTMyOTE0fQ.5tkFyq7qJ9ctAoiPSo9ujJCe44KFnC3aer6b7ePvw4I";

        validationToken(token);

    }

    public static String validationToken(String token){
        String SECRET_KEY = "YUN_TEST";

        Claims claims= Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

        log.info(claims.toString());

        return null;
    }
}
