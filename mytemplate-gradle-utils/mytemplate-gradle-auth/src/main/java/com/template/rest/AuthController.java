package com.template.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.JsonObject;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Base64;
import java.util.Map;

@RestController
@Slf4j
public class AuthController {

    private void printToken(String token){
        log.info("Token info : \n");
        log.info(token);

        String[] tokenArray = token.split("\\.");

        log.info("Header : {}", new String(Base64.getDecoder().decode(tokenArray[0])));
        log.info("Body   : {}", new String(Base64.getDecoder().decode(tokenArray[1])));
    }

    /**
     * Auth token generator JwtTokenTest_1
     * @return
     */
    @PostMapping("/jwt1")
    public JsonObject JwtTokenTest_1(){

        // Random Key
        String base64EncodedKey = "423F4528482B4D6251655468576D5A7134743777397A24432646294A404E6352";
        String name = "JJeongho";
        String testRole = "admin";

        // Base64 Encode
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(base64EncodedKey));

        String token =
                Jwts.builder().addClaims(
                                Map.of("name",name,"role",testRole)
                        ).signWith(key)
                        .compact();
        printToken(token);

        JsonObject json = new JsonObject();

        json.addProperty("name", name);
        json.addProperty("access_token", token);

        return json;
    }
}
