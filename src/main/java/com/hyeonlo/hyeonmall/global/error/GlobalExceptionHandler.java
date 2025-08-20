package com.hyeonlo.hyeonmall.global.error;

import com.hyeonlo.hyeonmall.global.payload.BaseResponse;
import com.hyeonlo.hyeonmall.global.payload.Basecode;
import com.hyeonlo.hyeonmall.global.payload.status.ErrorStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<Object>> customExceptionHandler(BaseException e) {
        Basecode errorCode = e.getCode();
        return hadlerExceptionInternal(errorCode);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<BaseResponse<Object>> handlerIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity
                .status(ErrorStatus.INVALID_REQUEST.getStatus())
                .body(BaseResponse.fail(ErrorStatus.INVALID_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> handleUnexpected(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(BaseResponse.fail(ErrorStatus.INTERNAL_SERVER_ERROR));
    }

    private ResponseEntity<BaseResponse<Object>> hadlerExceptionInternal(Basecode errorStatus) {
        return ResponseEntity.status(errorStatus.getStatus())
                .body(BaseResponse.fail(errorStatus));
    }
}