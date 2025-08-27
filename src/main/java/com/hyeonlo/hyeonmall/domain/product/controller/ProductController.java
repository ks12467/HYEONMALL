package com.hyeonlo.hyeonmall.domain.product.controller;

import com.hyeonlo.hyeonmall.domain.product.dto.response.CreateProductResponse;
import com.hyeonlo.hyeonmall.domain.product.dto.request.CreateProductRequest;
import com.hyeonlo.hyeonmall.domain.product.service.ProductService;
import com.hyeonlo.hyeonmall.domain.product.status.ProductSuccessStatus;
import com.hyeonlo.hyeonmall.global.payload.BaseResponse;
import com.hyeonlo.hyeonmall.global.security.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("v1/products")
    public BaseResponse<CreateProductResponse> createProduct(@AuthenticationPrincipal AuthUser authUser, @RequestBody CreateProductRequest createProductRequest) {
        CreateProductResponse product = productService.createProduct(authUser, createProductRequest);
        return BaseResponse.productSuccess(ProductSuccessStatus.CREATE_SUCCESS, product);
    }
}