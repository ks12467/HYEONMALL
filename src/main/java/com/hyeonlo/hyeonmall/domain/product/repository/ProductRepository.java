package com.hyeonlo.hyeonmall.domain.product.repository;

import com.hyeonlo.hyeonmall.domain.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
