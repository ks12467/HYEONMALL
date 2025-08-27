package com.hyeonlo.hyeonmall.domain.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatus {

    ON_SALE("판매중"),
    SALE("세일"),
    SOLD_OUT("품절"),;


    private final String message;

    ProductStatus(String message) {
        this.message = message;
    }
}