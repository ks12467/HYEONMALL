package com.hyeonlo.hyeonmall.domain.product.status;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ProductSuccessStatus {

    CREATE_SUCCESS(HttpStatus.CREATED.value(), "P001" , "상품이 성공적으로 등록되었습니다."),;

    private final int status;
    private final String code;
    private final String message;

    ProductSuccessStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}