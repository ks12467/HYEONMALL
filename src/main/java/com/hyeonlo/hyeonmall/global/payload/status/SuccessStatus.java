package com.hyeonlo.hyeonmall.global.payload.status;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessStatus {

    OK(HttpStatus.OK.value(), "S000", "요청이 성공적으로 수행되었습니다.");

    private final int status;
    private final String code;
    private final String message;

    SuccessStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
