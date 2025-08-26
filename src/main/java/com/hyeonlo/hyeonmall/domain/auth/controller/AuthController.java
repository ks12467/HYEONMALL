package com.hyeonlo.hyeonmall.domain.auth.controller;

import com.hyeonlo.hyeonmall.domain.auth.dto.CreateUserRequest;
import com.hyeonlo.hyeonmall.domain.auth.dto.CreateUserResponse;
import com.hyeonlo.hyeonmall.domain.auth.dto.request.LoginRequest;
import com.hyeonlo.hyeonmall.domain.auth.service.AuthService;
import com.hyeonlo.hyeonmall.domain.auth.status.AuthSuccessStatus;
import com.hyeonlo.hyeonmall.global.payload.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/v1/auth/signup")
    public BaseResponse<CreateUserResponse> signup(@RequestBody CreateUserRequest createUserRequest) {
        log.info("요청 들어옴");
        CreateUserResponse response = authService.signup(createUserRequest);

        return BaseResponse.authSuccess(AuthSuccessStatus.CREATE, response);
    }

    @PostMapping("/v1/auth/login")
    public BaseResponse<String> login(@RequestBody LoginRequest loginRequest) {
        String login = authService.login(loginRequest);
        return BaseResponse.authSuccess(AuthSuccessStatus.LOGIN_SUCCESS, login);
    }
}