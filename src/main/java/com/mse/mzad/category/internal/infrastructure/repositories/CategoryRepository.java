package com.mse.mzad.category.internal.infrastructure.repositories;

import com.mse.mzad.category.internal.domain.contracts.ICategoryRepo;
import com.mse.mzad.category.internal.domain.models.Category;
import com.mse.mzad.category.internal.infrastructure.database.CategoryEntity;
import com.mse.mzad.category.internal.infrastructure.mappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryRepository implements ICategoryRepo {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category create(Category newCategory) {
        if(newCategory.getParentId() != null) {
            CategoryEntity parentCategoryEntity = categoryRepository.findById(newCategory.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent Category not found"));
            CategoryEntity newCategoryEntity = CategoryMapper.toEntityForCreate(newCategory, parentCategoryEntity);
            return CategoryMapper.toDomain(categoryRepository.save(newCategoryEntity));
        }
        CategoryEntity newCategoryEntity = CategoryMapper.toEntityForCreate(newCategory, null);
        return CategoryMapper.toDomain(categoryRepository.save(newCategoryEntity));
    }

    @Override
    public Category update(Category existCategory) {
        if(existCategory.getParentId() != null) {
            CategoryEntity parentCategoryEntity = categoryRepository.findById(existCategory.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent Category not found"));
            CategoryEntity newCategoryEntity = CategoryMapper.toEntityForUpdate(existCategory, parentCategoryEntity);
            return CategoryMapper.toDomain(categoryRepository.save(newCategoryEntity));
        }
        CategoryEntity newCategoryEntity = CategoryMapper.toEntityForUpdate(existCategory, null);
        return CategoryMapper.toDomain(categoryRepository.save(newCategoryEntity));
    }

    @Override
    public Category findById(long categoryId) {
        CategoryEntity existCategoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.toDomain(existCategoryEntity);
    }

    @Override
    public void delete(Category existCategory) {
        if(existCategory.getParentId() != null) {
            CategoryEntity parentCategoryEntity = categoryRepository.findById(existCategory.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent Category not found"));
            categoryRepository.delete(CategoryMapper.toEntityForUpdate(existCategory, parentCategoryEntity));
        }
        categoryRepository.delete(CategoryMapper.toEntityForUpdate(existCategory, null));
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        List<Category> categoryList = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntityList) {
            categoryList.add(CategoryMapper.toDomain(categoryEntity));
        }
        return categoryList;
    }
}
