package com.jeongho.template.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum BaseResultResCode {


    /****
     * HttpStatus Value를 기본적으로 따라감
     */

    // 200 OK
    RS_2000("200", "성공", "Operation Successes", "OPERATION_SUCCESS")
    , RS_2001("200", "로그인 성공", "Login Successes", "LOGIN_SUCCESS")

    // 400 Error
    , RS_4000("400", "요청 실패", "Operation Failed", "OPERATION_FAILED")
    , RS_4001("400", "필수 파라미터 미입력", "Mandatory Parameter Error", "MANDATORY_PARAMETER_ERROR")
    , RS_4002("400", "지원하지 않는 타입", "Bad Format Error", "BAD_FORMAT_ERROR")
    , RS_4003("400", "잘못된 요청", "Bad Request", "BAD_REQUEST")


    // 401 Error
    , RS_4010("401", "미인증(로그인)", "Unauthenticated", "LOGIN_REQUIRED")
    , RS_4011("401", "미인증(인증코드)", "Unauthenticated", "AUTH_CODE_CHECK_REQUIRED")
    , RS_4012("401", "만료된 인증코드", "Expired Auth Code", "EXPIRED_AUTH_CODE")
    , RS_4013("401", "인증된 코드", "Already Authenticated Code", "ALREADY_AUTHENTICATED_ERROR")

    // 403 Error
    , RS_4030("403", "만료된 토큰", "Expired Token", "EXPIRED_TOKEN")
    , RS_4031("403", "잘못된 토큰", "Invalid Token", "INVALID_TOKEN")
    , RS_4032("403", "권한 없음", "Forbidden", "FORBIDDEN")
    , RS_4033("403", "기타 권한 오류", "Forbidden", "FORBIDDEN")

    // 404 Error
    , RS_4040("404", "페이지/파일 찾을 수 없음", "Not Found Error", "NOT_FOUND_ERROR")


    // 500 Error
    , RS_5000("500", "로그인 실패", "Login Failed", "LOGIN_FAILED")
    , RS_5001("500", "외부 서버 에러", "External Server Error", "EXTERNAL_SERVER_ERROR")
    , RS_5002("500", "내부 서버 에러", "Internal Server Error", "INTERVAL_SERVER_ERROR")

    ;

    @Getter
    private final String code;
    @Getter
    private final String koMsg;
    @Getter
    private final String enMsg;
    @Getter
    private final String name;

    private static final Map<String, BaseResultResCode> lookup = new HashMap<>();
    static {
        for (BaseResultResCode code : BaseResultResCode.values()){
            lookup.put(code.getCode(), code);
        }
    }

    public static BaseResultResCode get(String resultCode){
        return lookup.get(resultCode);
    }
}
