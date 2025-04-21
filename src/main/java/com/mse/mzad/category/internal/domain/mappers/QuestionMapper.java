package com.mse.mzad.category.internal.domain.mappers;

import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.CreateQuestionRequest;
import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.QuestionResponse;
import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.UpdateQuestionRequest;
import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;

public class QuestionMapper {

    public static CategoryQuestion toDomainForCreate(CreateQuestionRequest request) {
        return new CategoryQuestion(
            null,
            request.getCategoryId(),
            request.getQuestion(),
            request.getType(),
            request.getAnswer()
        );
    }

    public static CategoryQuestion toDomainForUpdate(UpdateQuestionRequest request) {
        return new CategoryQuestion(
                request.getId(),
                request.getCategoryId(),
                request.getQuestion(),
                request.getType(),
                request.getAnswer()
        );
    }

    public static QuestionResponse toQuestionResponse(CategoryQuestion question) {
        return new QuestionResponse (
            question.getId(),
            question.getCategoryId(),
            question.getQuestion(),
            question.getType(),
            question.getAnswer()
        );
    }

}
