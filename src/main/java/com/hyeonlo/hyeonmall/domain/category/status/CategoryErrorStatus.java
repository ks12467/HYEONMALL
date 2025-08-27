package com.hyeonlo.hyeonmall.domain.category.status;

import com.hyeonlo.hyeonmall.global.payload.Basecode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CategoryErrorStatus implements Basecode {

    NOT_FOUND(HttpStatus.NOT_FOUND.value(), "C001", "카테고리를 찾을 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;

    CategoryErrorStatus(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
