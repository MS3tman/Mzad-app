package com.mse.mzad.category.internal.infrastructure.mappers;

import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;
import com.mse.mzad.category.internal.infrastructure.database.CategoryEntity;
import com.mse.mzad.category.internal.infrastructure.database.CategoryQuestionEntity;

public class CategoryQuestionMapper {

    public static CategoryQuestionEntity toEntityForCreate(CategoryQuestion question, CategoryEntity categoryEntity) {
        return new CategoryQuestionEntity(
            null,
            categoryEntity,
            question.getQuestion(),
            question.getType(),
            question.getAnswer()
        );
    }

    public static CategoryQuestionEntity toEntityForUpdate(CategoryQuestion question, CategoryEntity categoryEntity) {
        return new CategoryQuestionEntity(
            question.getId(),
            categoryEntity,
            question.getQuestion(),
            question.getType(),
            question.getAnswer()
        );
    }

    public static CategoryQuestion toDomain(CategoryQuestionEntity question) {
        return new CategoryQuestion(
            question.getId(),
            question.getCategory().getId(),
            question.getQuestion(),
            question.getType(),
            question.getAnswer()
        );
    }
}
