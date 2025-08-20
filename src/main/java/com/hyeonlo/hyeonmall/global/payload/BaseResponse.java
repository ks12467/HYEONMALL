package com.hyeonlo.hyeonmall.global.payload;

import com.hyeonlo.hyeonmall.domain.auth.status.AuthSuccessStatus;
import com.hyeonlo.hyeonmall.global.payload.status.ErrorStatus;
import com.hyeonlo.hyeonmall.global.payload.status.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse<T> {

    private final boolean success;
    private final T data;
    private final String code;
    private final String message;
    private final int status;

    public static <T> BaseResponse<T> success(SuccessStatus status, T data) {
        return new BaseResponse<>(
                true,
                data,
                status.getCode(),
                status.getMessage(),
                status.getStatus()
        );
    }

    public static <T> BaseResponse<T> authSuccess(AuthSuccessStatus status, T data) {
        return new BaseResponse<>(
                true,
                data,
                status.getCode(),
                status.getMessage(),
                status.getStatus()
        );
    }


    public static <T> BaseResponse<T> fail(Basecode code) {
        return new BaseResponse<>(
                false,
                null,
                code.getCode(),
                code.getMessage(),
                code.getStatus()
        );
    }
}