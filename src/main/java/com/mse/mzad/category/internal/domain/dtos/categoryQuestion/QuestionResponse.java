package com.mse.mzad.category.internal.domain.dtos.categoryQuestion;

import com.mse.mzad.category.internal.domain.models.categoryQuestion.QuestionType;
import lombok.Getter;

@Getter
public class QuestionResponse {
    private long id;
    private long categoryId;
    private String question;
    private QuestionType type;
    private String answer;

    public QuestionResponse(
            long id,
            long categoryId,
            String question,
            QuestionType type,
            String answer
    ) {
        this.id = id;
        this.categoryId = categoryId;
        this.question = question;
        this.type = type;
        this.answer = answer;
    }
}
