package com.my.test.rest;

import com.my.test.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class MyTestApiResource {

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String testPostPage(){

        Member member = new Member();
        member.setName("윤정호");
        member.setAge("31");

        log.info(member.toString());

        return member.toString();
    }

}
