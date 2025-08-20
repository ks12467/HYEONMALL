package com.hyeonlo.hyeonmall.domain.user.client;

import com.hyeonlo.hyeonmall.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
