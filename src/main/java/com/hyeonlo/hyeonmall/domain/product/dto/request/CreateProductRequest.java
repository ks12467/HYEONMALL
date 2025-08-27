package com.hyeonlo.hyeonmall.domain.product.dto.request;

import com.hyeonlo.hyeonmall.domain.category.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateProductRequest {

    @NotBlank
    private String productName;

    @NotBlank
    private String description;

    @NotNull
    private int price;

    @NotBlank
    private Long categoryId;
}