package com.mse.mzad.category.internal.domain.mappers;

import com.mse.mzad.category.internal.domain.dtos.category.CategoryResponse;
import com.mse.mzad.category.internal.domain.dtos.category.CreateCategoryRequest;
import com.mse.mzad.category.internal.domain.dtos.category.UpdateCategoryRequest;
import com.mse.mzad.category.internal.domain.models.Category;

public class CategoryMapper {
    public static Category toDomainForCreate(CreateCategoryRequest request) {
        return new Category(
            null,
            request.getTitle(),
            request.getParentId(),
            null
        );
    }

    public static Category toDomainForUpdate(UpdateCategoryRequest request) {
        return new Category(
                request.getId(),
                request.getTitle(),
                request.getParentId(),
                null
        );
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(
            category.getId(),
            category.getTitle(),
            category.getParentId(),
            category.getImage(),
            category.getQuestions()
        );
    }
}
