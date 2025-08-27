package com.hyeonlo.hyeonmall.domain.admin.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aminId;

    private String loginId;

    private String password;

    private String adminName;

    private Admin(String loginId, String password, String adminName) {
        this.loginId = loginId;
        this.password = password;
        this.adminName = adminName;
    }

    public static Admin of(String loginId, String password, String adminName) {
        return new Admin(loginId, password, adminName);
    }

    public void changePassword(String password) {
        this.password = password;
    }
}