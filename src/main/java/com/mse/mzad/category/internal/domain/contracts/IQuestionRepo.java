package com.mse.mzad.category.internal.domain.contracts;

import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;

public interface IQuestionRepo {
    CategoryQuestion create(CategoryQuestion question);
    CategoryQuestion update(CategoryQuestion question);
    CategoryQuestion findById(long questionId);
    void delete(CategoryQuestion question);
}
