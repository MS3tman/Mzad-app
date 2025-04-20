package com.mse.mzad.category.internal.infrastructure.mappers;

import com.mse.mzad.category.internal.domain.models.Category;
import com.mse.mzad.category.internal.infrastructure.database.CategoryEntity;

public class CategoryMapper {

    public static CategoryEntity toEntityForCreate(Category newCategory, CategoryEntity categoryEntity) {
        return new CategoryEntity(
            newCategory.getTitle(),
            categoryEntity,
            newCategory.getImage()
        );
    }

    public static CategoryEntity toEntityForUpdate(Category category, CategoryEntity categoryEntity) {
        return new CategoryEntity(
            category.getId(),
            category.getTitle(),
            categoryEntity,
            category.getImage()
        );
    }

    public static Category toDomain(CategoryEntity categoryEntity) {
        Long parentId = null;
        if (categoryEntity.getParent() != null) {
            parentId = categoryEntity.getParent().getId();
        }
        return new Category(
            categoryEntity.getId(),
            categoryEntity.getTitle(),
            parentId,
            categoryEntity.getImage()
        );
    }

}
