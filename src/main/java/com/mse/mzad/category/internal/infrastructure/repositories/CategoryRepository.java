package com.mse.mzad.category.internal.infrastructure.repositories;

import com.mse.mzad.category.internal.domain.contracts.ICategoryRepo;
import com.mse.mzad.category.internal.domain.models.Category;
import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;
import com.mse.mzad.category.internal.infrastructure.database.CategoryEntity;
import com.mse.mzad.category.internal.infrastructure.database.CategoryQuestionEntity;
import com.mse.mzad.category.internal.infrastructure.mappers.CategoryMapper;
import com.mse.mzad.category.internal.infrastructure.mappers.CategoryQuestionMapper;
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
            return CategoryMapper.toDomain(categoryRepository.save(newCategoryEntity), null);
        }
        CategoryEntity newCategoryEntity = CategoryMapper.toEntityForCreate(newCategory, null);
        return CategoryMapper.toDomain(categoryRepository.save(newCategoryEntity), null);
    }

    @Override
    public Category update(Category existCategory) {
        if(existCategory.getParentId() != null) {
            CategoryEntity parentCategoryEntity = categoryRepository.findById(existCategory.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent Category not found"));
            CategoryEntity newCategoryEntity = CategoryMapper.toEntityForUpdate(existCategory, parentCategoryEntity);
            return CategoryMapper.toDomain(categoryRepository.save(newCategoryEntity), null);
        }
        CategoryEntity newCategoryEntity = CategoryMapper.toEntityForUpdate(existCategory, null);
        return CategoryMapper.toDomain(categoryRepository.save(newCategoryEntity), null);
    }

    @Override
    public Category findById(long categoryId) {
        CategoryEntity existCategoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        if (existCategoryEntity.getQuestions() != null){
            List<CategoryQuestion> categoryQuestionsList = new ArrayList<>();
            for (CategoryQuestionEntity categoryQuestionEntity : existCategoryEntity.getQuestions()) {
                categoryQuestionsList.add(CategoryQuestionMapper.toDomain(categoryQuestionEntity));
            }
            return CategoryMapper.toDomain(existCategoryEntity, categoryQuestionsList);
        }
        return CategoryMapper.toDomain(existCategoryEntity, null);
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
            List<CategoryQuestion> categoryQuestionList = new ArrayList<>();
            if (categoryEntity.getQuestions() != null) {
                for (CategoryQuestionEntity categoryQuestionEntity : categoryEntity.getQuestions()) {
                    categoryQuestionList.add(CategoryQuestionMapper.toDomain(categoryQuestionEntity));
                }
            }
            categoryList.add(CategoryMapper.toDomain(categoryEntity,categoryQuestionList));
        }
        return categoryList;
    }
}
