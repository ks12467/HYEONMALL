package com.hyeonlo.hyeonmall.domain.user.controller;

import com.hyeonlo.hyeonmall.domain.user.dto.request.UserUpdateRequest;
import com.hyeonlo.hyeonmall.domain.user.dto.response.UserProfileResponse;
import com.hyeonlo.hyeonmall.domain.user.service.UserService;
import com.hyeonlo.hyeonmall.domain.user.status.UserSuccessStatus;
import com.hyeonlo.hyeonmall.global.payload.BaseResponse;
import com.hyeonlo.hyeonmall.global.security.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/v1/user/profile")
    public BaseResponse<UserProfileResponse> profile(@AuthenticationPrincipal AuthUser authUser) {
        UserProfileResponse response = userService.profile(authUser);
        return BaseResponse.userSuccess(UserSuccessStatus.REQUEST_ACCEPTED, response);
    }

    @PatchMapping("/v1/user/profile")
    public BaseResponse<String> updateUser(@AuthenticationPrincipal AuthUser authUser, @RequestBody UserUpdateRequest userUpdateRequest) {
        String update = userService.updateUser(authUser, userUpdateRequest);
        return BaseResponse.userSuccess(UserSuccessStatus.UPDATE_SUCCESS, update);
    }

    @DeleteMapping
    public BaseResponse<String> deleteUser(@AuthenticationPrincipal AuthUser authUser) {
        String delete = userService.deleteUser(authUser);
        return BaseResponse.userSuccess(UserSuccessStatus.DELETE_SUCCESS, delete);
    }

}