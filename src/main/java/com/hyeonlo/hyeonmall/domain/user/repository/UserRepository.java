package com.hyeonlo.hyeonmall.domain.user.repository;

import com.hyeonlo.hyeonmall.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    boolean existsByLoginId(String loginId);

    Optional<Users> findByLoginId(String loginId);
}
