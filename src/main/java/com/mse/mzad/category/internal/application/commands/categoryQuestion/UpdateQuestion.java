package com.mse.mzad.category.internal.application.commands.categoryQuestion;

import com.mse.mzad.category.internal.domain.contracts.IQuestionRepo;
import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.QuestionResponse;
import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.UpdateQuestionRequest;
import com.mse.mzad.category.internal.domain.mappers.QuestionMapper;
import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;
import org.springframework.stereotype.Service;

@Service
public class UpdateQuestion {
    private final IQuestionRepo questionRepo;

    public UpdateQuestion(IQuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public QuestionResponse update(UpdateQuestionRequest request) {
        CategoryQuestion existCategoryQuestion = questionRepo.findById(request.getId());
        if(existCategoryQuestion == null) {
            throw new RuntimeException("Category Question not found");
        }
        CategoryQuestion categoryQuestion = questionRepo.update(QuestionMapper.toDomainForUpdate(request));
        return QuestionMapper.toQuestionResponse(categoryQuestion);
    }
}
