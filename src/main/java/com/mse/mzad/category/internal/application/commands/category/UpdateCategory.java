package com.mse.mzad.category.internal.application.commands.category;

import com.mse.mzad.category.internal.domain.contracts.ICategoryRepo;
import com.mse.mzad.category.internal.domain.dtos.category.CategoryResponse;
import com.mse.mzad.category.internal.domain.dtos.category.UpdateCategoryRequest;
import com.mse.mzad.category.internal.domain.mappers.CategoryMapper;
import com.mse.mzad.category.internal.domain.models.Category;
import org.springframework.stereotype.Service;

@Service
public class UpdateCategory {
    private final ICategoryRepo categoryRepo;

    public UpdateCategory(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public CategoryResponse update(UpdateCategoryRequest request) {
        Category existCategory = categoryRepo.findById(request.getId());
        if(existCategory == null) {
            throw new RuntimeException("Category not found");
        }
        Category category = CategoryMapper.toDomainForUpdate(request);
        return CategoryMapper.toCategoryResponse(categoryRepo.update(category));
    }
}
