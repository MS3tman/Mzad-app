package com.mse.mzad.category.internal.infrastructure.repositories;

import com.mse.mzad.category.internal.domain.contracts.IQuestionRepo;
import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;
import com.mse.mzad.category.internal.infrastructure.database.CategoryEntity;
import com.mse.mzad.category.internal.infrastructure.database.CategoryQuestionEntity;
import com.mse.mzad.category.internal.infrastructure.mappers.CategoryQuestionMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryQuestionRepository implements IQuestionRepo {
    private final ICategoryRepository categoryRepository;
    private final ICategoryQuestionRepository categoryQuestionRepository;

    public CategoryQuestionRepository(
            ICategoryRepository categoryRepository,
            ICategoryQuestionRepository categoryQuestionRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.categoryQuestionRepository = categoryQuestionRepository;
    }

    @Override
    public CategoryQuestion create(CategoryQuestion question) {
        CategoryEntity categoryEntity = categoryRepository.findById(question.getCategoryId()).orElseThrow(() -> new RuntimeException("category not found"));
        CategoryQuestionEntity existQuestionEntity = CategoryQuestionMapper.toEntityForCreate(question, categoryEntity);
        return CategoryQuestionMapper.toDomain(categoryQuestionRepository.save(existQuestionEntity));
    }

    @Override
    public CategoryQuestion update(CategoryQuestion question) {
        categoryQuestionRepository.findById(question.getId()).orElseThrow(() -> new RuntimeException("Question not found"));
        CategoryEntity categoryEntity = categoryRepository.findById(question.getCategoryId()).orElseThrow(() -> new RuntimeException("category not found"));
        CategoryQuestionEntity existQuestionEntity = CategoryQuestionMapper.toEntityForUpdate(question, categoryEntity);
        return CategoryQuestionMapper.toDomain(categoryQuestionRepository.save(existQuestionEntity));
    }

    @Override
    public CategoryQuestion findById(long questionId) {
        CategoryQuestionEntity existQuestionEntity = categoryQuestionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("question not found"));
        return CategoryQuestionMapper.toDomain(existQuestionEntity);
    }

    @Override
    public void delete(CategoryQuestion question) {
        CategoryQuestionEntity existQuestionEntity = categoryQuestionRepository.findById(question.getId()).orElseThrow(() -> new RuntimeException("question not found"));
        categoryQuestionRepository.delete(existQuestionEntity);
    }
}
