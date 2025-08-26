package com.hyeonlo.hyeonmall.domain.user.dto.response;

import lombok.Getter;

@Getter
public class UserProfileResponse {

    private final Long userId;
    private final String loginId;
    private final String userName;
    private final String number;

    private UserProfileResponse(Long userId, String loginId, String userName, String number) {
        this.userId = userId;
        this.loginId = loginId;
        this.userName = userName;
        this.number =  number;
    }

    public static UserProfileResponse of(Long userId, String loginId, String userName, String number) {
        return new UserProfileResponse(
                userId, loginId, userName, number);
    }
}