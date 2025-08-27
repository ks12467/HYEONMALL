package com.hyeonlo.hyeonmall.domain.product.dto.response;

import lombok.Getter;

@Getter
public class CreateProductResponse {

    private final Long productId;
    private final String productName;
    private final int price;
    private final Long categoryId;
    private final Long userId;

    private CreateProductResponse(Long productId, String productName, int price, Long categoryId, Long userId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public static CreateProductResponse of(Long productId, String productName, int price, Long categoryId, Long userId) {
        return new CreateProductResponse(productId, productName, price, categoryId, userId);
    }
}