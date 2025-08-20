package com.hyeonlo.hyeonmall.domain.user.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE("활성화 계정"),
    WITHDRAW("비활성화 계정");

    private final String message;

    UserStatus(String message) {
        this.message = message;
    }
}
