package com.hyeonlo.hyeonmall.domain.user.service;

import com.hyeonlo.hyeonmall.domain.auth.dto.CreateUserRequest;
import com.hyeonlo.hyeonmall.domain.user.client.UserRepository;
import com.hyeonlo.hyeonmall.domain.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean existLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }

    public Users createUser(String loginId, String encoded, String userName, String number) {
        Users user = Users.of(loginId, encoded, userName, number);
        return userRepository.save(user);
    }
}