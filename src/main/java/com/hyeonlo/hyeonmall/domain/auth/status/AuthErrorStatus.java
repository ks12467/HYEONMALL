package com.hyeonlo.hyeonmall.domain.auth.status;

import com.hyeonlo.hyeonmall.global.payload.Basecode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum AuthErrorStatus implements Basecode {

    ALREADY_LOGIN_ID(HttpStatus.BAD_REQUEST.value(), "E100", "해당 아이디는 이미 존재합니다");


    private final int status;
    private final String code;
    private final String message;

    AuthErrorStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
