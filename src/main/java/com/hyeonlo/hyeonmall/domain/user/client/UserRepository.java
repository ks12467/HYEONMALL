package com.hyeonlo.hyeonmall.domain.user.client;

import com.hyeonlo.hyeonmall.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    boolean existsByLoginId(String loginId);
}
