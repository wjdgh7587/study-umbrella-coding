package com.template.entity.enums;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public enum ResultResCode {

    // 200 All Success Things is going to process with this
    US_200_0("200_0","로그인 성공", "Operation Success")

    // 400
    , US_400_0("400_0", "필수 파라미터 미입력", "Mandatory Parameter Error")
    , US_400_1("400_1", "잘못된 포멧", "Invalid Parameter Error")
    , US_400_2("400_2", "지원하지 않는 타입", "Bad Format Error")
    , US_400_9("400_3", "요청 실패", "Bad Request")

    // 401
    , US_401_0("401_0", "미인증(로그인)", "Unauthenticated")
    , US_401_1("401_1", "미인증(인증코드)", "Unauthenticated")
    , US_401_2("401_2", "만료된 인증코드", "Expired Auth Code")
    , US_401_3("401_3", "인증된 코드", "Already Authenticated Code")

    //403
    , US_403_0("403_0", "만료된 토큰", "Expired Token")
    , US_403_1("403_1", "잘못된 토큰", "Invalid Token")
    , US_403_2("403_2", "권한 없음", "Forbidden")
    , US_403_9("403_9", "기타 권한 오류", "Forbidden")

    // 404
    , US_404_0("404_0", "페이지/파일 찾을 수 없음", "Not Found Error")

    // 500
    , US_500_0("500_0", "로그인 실패", "Login Failed")
    , US_500_1("500_1", "조회 실패", "Search Failed")
    , US_500_2("500_2", "등록 실패", "Addition Failed")
    , US_500_3("500_3", "생성 실패", "Generation Failed")
    , US_500_4("500_4", "수정 실패", "Modification Failed")
    , US_500_5("500_5", "삭제 실패", "Deletion Failed")
    , US_500_6("500_6", "외부 서버 에러", "External Server Error")
    , US_500_7("500_7", "내부 서버 에러", "Internal Server Error")
    ;

    @Getter
    private final String resultCode;
    @Getter
    private final String resultMsgKo;
    @Getter
    private final String resultMsgEn;

    //    private static final Map<String, ResultResCode> lookup = Maps.uniqueIndex(
//            List.of(ResultResCode.values()) ,
//            ResultResCode::getResultCode
//    );

    // Without Google Guava Library
    private static final Map<String, ResultResCode> lookup = new HashMap<>();
    static {
        for (ResultResCode code : ResultResCode.values()) {
            lookup.put(code.getResultCode(), code);
        }
    }

    public static ResultResCode get(String resultCode){
        return lookup.get(resultCode);
    }
}
