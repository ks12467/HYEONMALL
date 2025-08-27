package com.hyeonlo.hyeonmall.domain.category.service;

import com.hyeonlo.hyeonmall.domain.category.domain.Category;
import com.hyeonlo.hyeonmall.domain.category.repository.CategoryRepository;
import com.hyeonlo.hyeonmall.domain.category.status.CategoryErrorStatus;
import com.hyeonlo.hyeonmall.global.error.BaseException;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category findById(@NotBlank Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new BaseException(CategoryErrorStatus.NOT_FOUND));
    }
}