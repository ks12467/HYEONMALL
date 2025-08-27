package com.hyeonlo.hyeonmall.domain.user.domain;

import com.hyeonlo.hyeonmall.domain.product.domain.Product;
import com.hyeonlo.hyeonmall.domain.user.enums.UserRole;
import com.hyeonlo.hyeonmall.domain.user.enums.UserStatus;
import com.hyeonlo.hyeonmall.global.utils.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Users extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String loginId;

    private String password;

    private String userName;

    private String number;

    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.USER;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus = UserStatus.ACTIVE;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    private Users(String loginId, String password, String userName, String number) {
        this.loginId = loginId;
        this.password = password;
        this.userName = userName;
        this.number = number;
    }

    public static Users of(String loginId, String password, String userName, String number) {
        return new Users(
                loginId,
                password,
                userName,
                number
        );
    }

    public void updateLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }

    public void updateNumber(String number) {
        this.number = number;
    }

    public void changeUserStatus() {
        this.userStatus = UserStatus.WITHDRAW;
    }
}