package com.hyeonlo.hyeonmall.domain.product.status;

import com.hyeonlo.hyeonmall.global.error.BaseException;
import com.hyeonlo.hyeonmall.global.payload.Basecode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ProductErrorStatus implements Basecode {

    USER_NOT_SELLER(HttpStatus.BAD_REQUEST.value(), "P100" , "판매자만 상품을 등록할 수 있습니다."),;

    private final int status;
    private final String code;
    private final String message;

    ProductErrorStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
