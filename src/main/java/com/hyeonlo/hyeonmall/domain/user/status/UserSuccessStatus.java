package com.hyeonlo.hyeonmall.domain.user.status;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum UserSuccessStatus {

    REQUEST_ACCEPTED(HttpStatus.ACCEPTED.value(), "S101" , "유저 프로필 조회에 성공하였습니다."),
    UPDATE_SUCCESS(HttpStatus.OK.value(), "S102", "유저 정보 업데이트에 성공하였습니다."),
    DELETE_SUCCESS(HttpStatus.ACCEPTED.value(), "S103","회원탈퇴가 성공적으로 처리되었습니다." );

    private final int status;
    private final String code;
    private final String message;

    UserSuccessStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}