package com.mse.mzad.category.internal.application.queries.category;

import com.mse.mzad.category.internal.domain.contracts.ICategoryImageHandler;
import com.mse.mzad.category.internal.domain.contracts.ICategoryRepo;
import com.mse.mzad.category.internal.domain.models.Category;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategory {
    private final ICategoryRepo categoryRepo;
    private final ICategoryImageHandler categoryImageHandler;

    public DeleteCategory(
            ICategoryRepo categoryRepo,
            ICategoryImageHandler categoryImageHandler
    ) {
        this.categoryRepo = categoryRepo;
        this.categoryImageHandler = categoryImageHandler;
    }

    public void delete(long categoryId) {
        Category existCategory = categoryRepo.findById(categoryId);
        if (existCategory == null) {
            throw new RuntimeException("Category not found");
        }
        if(existCategory.getImage() != null) {
            categoryImageHandler.deleteImage(existCategory.getImage());
            categoryRepo.delete(existCategory);
        } else {
            categoryRepo.delete(existCategory);
        }
    }
}
