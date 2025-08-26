package com.hyeonlo.hyeonmall.domain.user.service;

import com.hyeonlo.hyeonmall.domain.user.dto.request.UserUpdateRequest;
import com.hyeonlo.hyeonmall.domain.user.dto.response.UserProfileResponse;
import com.hyeonlo.hyeonmall.domain.user.repository.UserRepository;
import com.hyeonlo.hyeonmall.domain.user.domain.Users;
import com.hyeonlo.hyeonmall.domain.user.status.UserErrorStatus;
import com.hyeonlo.hyeonmall.global.error.BaseException;
import com.hyeonlo.hyeonmall.global.security.AuthUser;
import com.hyeonlo.hyeonmall.global.utils.PasswordEncoder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Users createUser(String loginId, String encoded, String userName, String number) {
        Users user = Users.of(loginId, encoded, userName, number);
        return userRepository.save(user);
    }

    public UserProfileResponse profile(AuthUser authUser) {
        Users user = userRepository.findByLoginId(authUser.getLoginId()).orElseThrow(
                () -> new BaseException(UserErrorStatus.NOT_FOUND_LOGINID)
        );

        return UserProfileResponse.of(
                user.getUserId(),
                user.getLoginId(),
                user.getUserName(),
                user.getNumber()
        );
    }

    @Transactional
    public String updateUser(AuthUser authUser, UserUpdateRequest userUpdateRequest) {
        Users user = userRepository.findByLoginId(authUser.getLoginId()).orElseThrow(
                () -> new BaseException(UserErrorStatus.NOT_FOUND_LOGINID)
        );

        if(!passwordEncoder.match(userUpdateRequest.getCurrentPassword(), user.getPassword())) {
            throw new BaseException(UserErrorStatus.INVALID_PASSWORD);
        }

        if(userUpdateRequest.getNewLoginId() != null && !userUpdateRequest.getNewName().isBlank()) {
            user.updateLoginId(userUpdateRequest.getNewLoginId());
        }

        if(userUpdateRequest.getCurrentPassword() != null && !userUpdateRequest.getNewPassword().isBlank()) {
            String encodedPassword = passwordEncoder.encode(userUpdateRequest.getNewPassword());
            user.updatePassword(encodedPassword);
        }

        if(userUpdateRequest.getNewName() != null && !userUpdateRequest.getNewName().isBlank()) {
            user.updateUserName(userUpdateRequest.getNewName());
        }
        if(userUpdateRequest.getNewNumber() != null && !userUpdateRequest.getNewNumber().isBlank()) {
            user.updateNumber(userUpdateRequest.getNewNumber());
        }

        userRepository.save(user);

        return "업데이트 완료";
    }

    @Transactional
    public String deleteUser(AuthUser authUser) {
        Users user = userRepository.findByLoginId(authUser.getLoginId()).orElseThrow(
                () -> new BaseException(UserErrorStatus.NOT_FOUND_LOGINID)
        );

        user.changeUserStatus();

        userRepository.save(user);

        return "회원탈퇴 완료";
    }

    public Users findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId).orElseThrow(() -> new BaseException(UserErrorStatus.NOT_FOUND_LOGINID));
    }

    public boolean existLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }


}