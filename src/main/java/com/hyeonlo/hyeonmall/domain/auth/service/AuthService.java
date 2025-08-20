package com.hyeonlo.hyeonmall.domain.auth.service;

import com.hyeonlo.hyeonmall.domain.auth.dto.CreateUserRequest;
import com.hyeonlo.hyeonmall.domain.auth.dto.CreateUserResponse;
import com.hyeonlo.hyeonmall.domain.auth.status.AuthErrorStatus;
import com.hyeonlo.hyeonmall.domain.user.domain.Users;
import com.hyeonlo.hyeonmall.domain.user.service.UserService;
import com.hyeonlo.hyeonmall.global.error.BaseException;
import com.hyeonlo.hyeonmall.global.utils.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public CreateUserResponse signup(CreateUserRequest createUserRequest) {
        if(userService.existLoginId(createUserRequest.getLoginId())) {
            throw new BaseException(AuthErrorStatus.ALREADY_LOGIN_ID);
        }
        String encoded = passwordEncoder.encode(createUserRequest.getPassword());
        Users user = userService.createUser(createUserRequest.getLoginId(), encoded, createUserRequest.getUserName(), createUserRequest.getNumber());

        return CreateUserResponse.of(
                user.getUserId(),
                user.getUserName(),
                user.getNumber()
        );
    }
}