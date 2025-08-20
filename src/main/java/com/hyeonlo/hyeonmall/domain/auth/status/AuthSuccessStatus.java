package com.hyeonlo.hyeonmall.domain.auth.status;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum AuthSuccessStatus {

    OK(HttpStatus.OK.value(), "S100", "요청이 성공적으로 수행되었습니다."),
    CREATE(HttpStatus.CREATED.value(), "S101","성공적으로 생성되었습니다." );

    private final int status;
    private final String code;
    private final String message;

    AuthSuccessStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}

