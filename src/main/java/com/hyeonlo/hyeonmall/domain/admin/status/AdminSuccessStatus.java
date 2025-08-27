package com.hyeonlo.hyeonmall.domain.admin.status;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum AdminSuccessStatus {

    ADMIN_SUCCESS_STATUS(HttpStatus.CREATED.value(), "A000", "관리자 기능이 성공적으로 처리되었습니다."),
    SELLER_PENDING_LIST_SUCCESS(HttpStatus.ACCEPTED.value(), "AS000", "판매자 신청 리스트 조회에 성공하였습니다." ),
    SELLER_APPROVE_SUCCESS(HttpStatus.ACCEPTED.value(), "AS001","판매자 권한이 승인되었습니다." );

    private final int status;
    private final String code;
    private final String message;

    AdminSuccessStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
