package com.hyeonlo.hyeonmall.domain.user.service;

import com.hyeonlo.hyeonmall.domain.user.client.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}