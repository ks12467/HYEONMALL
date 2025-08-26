package com.hyeonlo.hyeonmall.domain.auth.service;

import com.hyeonlo.hyeonmall.domain.auth.dto.request.CreateUserRequest;
import com.hyeonlo.hyeonmall.domain.auth.dto.CreateUserResponse;
import com.hyeonlo.hyeonmall.domain.auth.dto.request.LoginRequest;
import com.hyeonlo.hyeonmall.domain.auth.status.AuthErrorStatus;
import com.hyeonlo.hyeonmall.domain.user.domain.Users;
import com.hyeonlo.hyeonmall.domain.user.enums.UserStatus;
import com.hyeonlo.hyeonmall.domain.user.service.UserService;
import com.hyeonlo.hyeonmall.global.error.BaseException;
import com.hyeonlo.hyeonmall.global.security.JwtUtil;
import com.hyeonlo.hyeonmall.global.utils.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public CreateUserResponse signup(CreateUserRequest createUserRequest) {
        log.info("아이디 중복 검사");
        if(userService.existLoginId(createUserRequest.getLoginId())) {
            throw new BaseException(AuthErrorStatus.ALREADY_LOGIN_ID);
        }
        log.info("비밀번호 인코딩");
        String encoded = passwordEncoder.encode(createUserRequest.getPassword());
        log.info("유저 저장");
        Users user = userService.createUser(createUserRequest.getLoginId(), encoded, createUserRequest.getUserName(), createUserRequest.getNumber());
        log.info(("응답 변환"));
        return CreateUserResponse.of(
                user.getUserId(),
                user.getLoginId(),
                user.getUserName()
        );
    }

    public String login(LoginRequest loginRequest) {
        Users user = userService.findByLoginId(loginRequest.getLoginId());

        if(!passwordEncoder.match(loginRequest.getPassword(), user.getPassword())) {
            throw new BaseException(AuthErrorStatus.INVALID_PASSWORD);
        }

        if(user.getUserStatus().equals(UserStatus.WITHDRAW)) {
            throw new BaseException(AuthErrorStatus.WITHDRAW_ACOUNT);
        }

        String token = jwtUtil.createToken(user.getUserId(),user.getLoginId(),user.getUserRole());
        return "로그인 성공, 토큰 : " + token;
    }
}