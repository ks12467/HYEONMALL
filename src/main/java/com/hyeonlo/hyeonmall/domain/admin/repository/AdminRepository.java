package com.hyeonlo.hyeonmall.domain.admin.repository;

import com.hyeonlo.hyeonmall.domain.admin.domain.Admin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existByLoginId(String loginId);
}
