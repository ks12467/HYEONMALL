package com.hyeonlo.hyeonmall.domain.auth.status;

import com.hyeonlo.hyeonmall.global.payload.Basecode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum AuthErrorStatus implements Basecode {

    ALREADY_LOGIN_ID(HttpStatus.BAD_REQUEST.value(), "E100", "해당 아이디는 이미 존재합니다"),
    NOT_FOUND_LOGINID(HttpStatus.NO_CONTENT.value(), "E101", "해당 아이디는 존재하지 않습니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST.value(),"E102" , "비밀번호가 일치하지 않습니다."),
    WITHDRAW_ACOUNT(HttpStatus.NO_CONTENT.value(), "E103", "해당 아이디는 탈퇴한 아이디입니다.");


    private final int status;
    private final String code;
    private final String message;

    AuthErrorStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
