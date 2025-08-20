package com.hyeonlo.hyeonmall.domain.user.exception;

import com.hyeonlo.hyeonmall.global.payload.Basecode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum UserErrorStatus implements Basecode {
    INVALID_AUTHORITY(HttpStatus.NOT_FOUND.value(), "E100" ,"잘못된 권한입니다." );

    private final int status;
    private final String code;
    private final String message;

    UserErrorStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
