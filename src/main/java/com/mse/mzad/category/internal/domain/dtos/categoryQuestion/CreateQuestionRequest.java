package com.mse.mzad.category.internal.domain.dtos.categoryQuestion;

import com.mse.mzad.category.internal.domain.models.categoryQuestion.QuestionType;
import lombok.Getter;

@Getter
public class CreateQuestionRequest {
    private long categoryId;
    private String question;
    private QuestionType type;
    private String answer;
}
