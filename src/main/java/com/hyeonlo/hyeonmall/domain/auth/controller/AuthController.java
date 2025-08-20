package com.hyeonlo.hyeonmall.domain.auth.controller;

import com.hyeonlo.hyeonmall.domain.auth.dto.CreateUserRequest;
import com.hyeonlo.hyeonmall.domain.auth.dto.CreateUserResponse;
import com.hyeonlo.hyeonmall.domain.auth.service.AuthService;
import com.hyeonlo.hyeonmall.domain.auth.status.AuthSuccessStatus;
import com.hyeonlo.hyeonmall.global.payload.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/v1/signup")
    public BaseResponse<CreateUserResponse> signup(@RequestBody CreateUserRequest createUserRequest) {
        CreateUserResponse response = authService.signup(createUserRequest);
        return BaseResponse.authSuccess(AuthSuccessStatus.CREATE, response);
    }
}