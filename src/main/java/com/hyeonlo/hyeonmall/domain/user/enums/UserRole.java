package com.hyeonlo.hyeonmall.domain.user.enums;

import com.hyeonlo.hyeonmall.domain.user.status.UserErrorStatus;
import com.hyeonlo.hyeonmall.global.error.BaseException;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UserRole {

    USER("사용자"),
    ADMIN("관리자");

    private final String message;

    private UserRole(String message){
        this.message = message;
    }

    public static UserRole of(String name) {
        return Arrays.stream(UserRole.values())
                .filter(role -> role.name().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new BaseException(UserErrorStatus.INVALID_AUTHORITY));
    }
}
