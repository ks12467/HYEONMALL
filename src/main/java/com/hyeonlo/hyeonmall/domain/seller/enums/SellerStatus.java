package com.hyeonlo.hyeonmall.domain.seller.enums;

import lombok.Getter;

@Getter
public enum SellerStatus {

    PENDING("판매자 승인 대기중"),
    APPROVED("판매자 승인 완료"),
    REJECTED("판매자 승인 거절");

    private final String message;

    SellerStatus(String message) {
        this.message = message;
    }
}
