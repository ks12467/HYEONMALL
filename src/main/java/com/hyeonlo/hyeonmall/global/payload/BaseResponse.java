package com.hyeonlo.hyeonmall.global.payload;

import com.hyeonlo.hyeonmall.domain.admin.status.AdminSuccessStatus;
import com.hyeonlo.hyeonmall.domain.auth.status.AuthSuccessStatus;
import com.hyeonlo.hyeonmall.domain.product.status.ProductSuccessStatus;
import com.hyeonlo.hyeonmall.domain.user.status.UserSuccessStatus;
import com.hyeonlo.hyeonmall.global.payload.status.ErrorStatus;
import com.hyeonlo.hyeonmall.global.payload.status.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

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

    public static <T> BaseResponse<T> userSuccess(UserSuccessStatus status, T data) {
        return new BaseResponse<>(
                true,
                data,
                status.getCode(),
                status.getMessage(),
                status.getStatus()
        );
    }

    public static <T> BaseResponse<T> productSuccess(ProductSuccessStatus status, T data) {
        return new BaseResponse<>(
                true,
                data,
                status.getCode(),
                status.getMessage(),
                status.getStatus()
        );
    }

    public static <T> BaseResponse<T> adminSuccess(AdminSuccessStatus status, T data) {
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