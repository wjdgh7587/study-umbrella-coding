package com.template.api;

import com.template.entity.enums.ResultResCode;
import com.template.entity.results.LoginResult;
import com.template.entity.results.ResultMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin("*")
public class LoginController {

    private String loginValidation(){

        return null;
    }

    @PostMapping("/api/login")
    public ResponseEntity<ResultMessage<LoginResult>> login(
        @RequestBody HttpServletRequest request, String test) throws Exception {


        LoginResult loginResult = new LoginResult();

        // RSA 패스워드 복호화
        String decryptPassword = "";

        // Test Code
//        loginResult.setLoginResult(r);

        // Login History


        ResultMessage<LoginResult> msg = new ResultMessage<>();

        msg.setPayload(loginResult);
        msg.setResultCode(ResultResCode.US_200_0.getResultCode());
        msg.setResultMessage(ResultResCode.US_200_0.getResultMsgKo());

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

}
