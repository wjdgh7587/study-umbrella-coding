package com.template;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.Date;

@Slf4j
public class TokenGen {

    private static final String SECRET_KEY = "YUN_TEST";
    private static final long EXPIRE_SETTING_TIME = 24 * 60 * 60 * 1000L;

    public static void main(String[] args) {
        System.out.println("Hello Auth");

        Date now = new Date();
        Date expireTime = new Date(now.getTime() + EXPIRE_SETTING_TIME);

        byte[] secretBytes = Base64.decodeBase64(encodeBase64Key(SECRET_KEY));

        Claims claims = Jwts.claims();
        claims.put("userId", "test_yun");

        String tokenResult = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireTime)
                .signWith(SignatureAlgorithm.HS256, secretBytes)
                .compact();

        log.info(tokenResult);
    }

    //eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJ0ZXN0X3l1biIsImlhdCI6MTY4NTQ0NjUxNCwiZXhwIjoxNjg1NTMyOTE0fQ.5tkFyq7qJ9ctAoiPSo9ujJCe44KFnC3aer6b7ePvw4I
    public static String encodeBase64Key(String secretKey){
        String encodedKey = Base64.encodeBase64String(secretKey.getBytes());
        log.info("encodedKey Test value : {}", encodedKey);

        return encodedKey;
    }


}
