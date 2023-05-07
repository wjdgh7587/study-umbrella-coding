package com.template.entity.results;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginResult {

    // 로그인 결과
    private String loginResult;
    // 로그인 카운트(실패) normal = 0; failed = count++
    private String loginCount;
    // 토큰
    private List<String> tokens;

}
