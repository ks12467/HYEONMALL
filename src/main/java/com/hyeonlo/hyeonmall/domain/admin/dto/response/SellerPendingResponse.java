package com.hyeonlo.hyeonmall.domain.admin.dto.response;

import lombok.Getter;

@Getter
public class SellerPendingResponse {

    private final Long sellerId;
    private final String shopName;

    private SellerPendingResponse(Long sellerId, String shopName) {
        this.sellerId = sellerId;
        this.shopName = shopName;
    }

    public static SellerPendingResponse of(Long sellerId, String shopName) {
        return new SellerPendingResponse(sellerId, shopName);
    }
}