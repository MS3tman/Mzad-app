package com.mse.mzad.category.internal.domain.models.categoryQuestion;

import lombok.Getter;

@Getter
public class CategoryQuestion {
    private Long id;
    private long categoryId;
    private String question;
    private QuestionType type;
    private String answer;

    public CategoryQuestion(
            Long id,
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
