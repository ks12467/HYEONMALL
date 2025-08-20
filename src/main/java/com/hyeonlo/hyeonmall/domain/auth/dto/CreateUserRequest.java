package com.hyeonlo.hyeonmall.domain.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequest {

    private String loginId;
    private String password;
    private String userName;
    private String number;
}