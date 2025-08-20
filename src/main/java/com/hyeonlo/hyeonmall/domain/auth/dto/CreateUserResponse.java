package com.hyeonlo.hyeonmall.domain.auth.dto;

import lombok.Getter;

@Getter
public class CreateUserResponse {

    private final Long userId;
    private final String loginId;
    private final String userName;

    private CreateUserResponse(Long userId, String loginId, String userName) {
        this.userId = userId;
        this.loginId = loginId;
        this.userName = userName;
    }

    public static CreateUserResponse of(Long userId, String loginId, String userName) {
        return new CreateUserResponse(
                userId, loginId, userName);
    }
}