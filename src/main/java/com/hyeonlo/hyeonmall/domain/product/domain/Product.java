package com.hyeonlo.hyeonmall.domain.product.domain;

import com.hyeonlo.hyeonmall.domain.category.domain.Category;
import com.hyeonlo.hyeonmall.domain.product.enums.ProductStatus;
import com.hyeonlo.hyeonmall.domain.user.domain.Users;
import com.hyeonlo.hyeonmall.global.utils.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String productName;

    private String description;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users seller;

    private ProductStatus productStatus = ProductStatus.ON_SALE;

    private Product(String productName, String description, int price, Category category, Users seller) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.seller = seller;
    }

    public static Product of(String productName, String description, int price, Category category, Users seller) {
        return new Product(
                productName,
                description,
                price,
                category,
                seller
        );
    }

    public void updateProductName(String productName) {
        this.productName = productName;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updatePrice(int price) {
        this.price = price;
    }

    public void changeCategory(Category category) {
        this.category = category;
    }

    public void changeProductStatusBySale(ProductStatus productStatus) {
        this.productStatus = ProductStatus.SALE;
    }

    public void changeProductStatusBySoldOut(ProductStatus productStatus) {
        this.productStatus = ProductStatus.SOLD_OUT;
    }
}