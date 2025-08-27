package com.hyeonlo.hyeonmall.domain.product.service;

import com.hyeonlo.hyeonmall.domain.category.domain.Category;
import com.hyeonlo.hyeonmall.domain.category.service.CategoryService;
import com.hyeonlo.hyeonmall.domain.product.domain.Product;
import com.hyeonlo.hyeonmall.domain.product.dto.response.CreateProductResponse;
import com.hyeonlo.hyeonmall.domain.product.dto.request.CreateProductRequest;
import com.hyeonlo.hyeonmall.domain.product.repository.ProductRepository;
import com.hyeonlo.hyeonmall.domain.product.status.ProductErrorStatus;
import com.hyeonlo.hyeonmall.domain.user.domain.Users;
import com.hyeonlo.hyeonmall.domain.user.enums.UserRole;
import com.hyeonlo.hyeonmall.domain.user.service.UserService;
import com.hyeonlo.hyeonmall.global.error.BaseException;
import com.hyeonlo.hyeonmall.global.security.AuthUser;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;


    @Transactional
    public CreateProductResponse createProduct(AuthUser authUser, CreateProductRequest createProductRequest) {
        Users user = userService.findByLoginId(authUser.getLoginId());

        if(!user.getUserRole().equals(UserRole.SELLER)) {
            throw new BaseException(ProductErrorStatus.USER_NOT_SELLER);
        }

        Category category = categoryService.findById(createProductRequest.getCategoryId());

        Product product = Product.of(
                createProductRequest.getProductName(),
                createProductRequest.getDescription(),
                createProductRequest.getPrice(),
                category,
                user);

        productRepository.save(product);

        return CreateProductResponse.of(
                product.getProductId(),
                product.getProductName(),
                product.getPrice(),
                product.getCategory().getCategoryId(),
                product.getSeller().getUserId()
        );
    }
}