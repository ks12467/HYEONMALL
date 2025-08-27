package com.hyeonlo.hyeonmall.domain.category.repository;

import com.hyeonlo.hyeonmall.domain.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
