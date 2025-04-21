package com.mse.mzad.category.internal.application.queries.categoryQuestion;

import com.mse.mzad.category.internal.domain.contracts.IQuestionRepo;
import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;
import org.springframework.stereotype.Service;

@Service
public class DeleteQuestion {
    private final IQuestionRepo questionRepo;

    public DeleteQuestion(IQuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public void delete(long questionId) {
        CategoryQuestion existCategoryQuestion = questionRepo.findById(questionId);
        if(existCategoryQuestion == null) {
            throw new RuntimeException("Category Question not found");
        }
        questionRepo.delete(existCategoryQuestion);
    }
}
