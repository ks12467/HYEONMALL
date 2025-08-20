package com.hyeonlo.hyeonmall.global.error;

import com.hyeonlo.hyeonmall.global.payload.Basecode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseException extends RuntimeException{

    private final Basecode code;
}