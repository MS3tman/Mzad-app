package com.mse.mzad.category.internal.application.commands.category;

import com.mse.mzad.category.internal.domain.contracts.ICategoryRepo;
import com.mse.mzad.category.internal.domain.dtos.category.CategoryResponse;
import com.mse.mzad.category.internal.domain.dtos.category.CreateCategoryRequest;
import com.mse.mzad.category.internal.domain.mappers.CategoryMapper;
import com.mse.mzad.category.internal.domain.models.Category;
import org.springframework.stereotype.Service;

@Service
public class CreateCategory {
    private final ICategoryRepo categoryRepo;

    public CreateCategory(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public CategoryResponse create(CreateCategoryRequest request) {
        Category newCategory = CategoryMapper.toDomainForCreate(request);
        return CategoryMapper.toCategoryResponse(categoryRepo.create(newCategory));
    }
}
