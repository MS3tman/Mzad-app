package com.mse.mzad.category.internal.application.commands.categoryQuestion;

import com.mse.mzad.category.internal.domain.contracts.IQuestionRepo;
import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.CreateQuestionRequest;
import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.QuestionResponse;
import com.mse.mzad.category.internal.domain.mappers.QuestionMapper;
import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;
import org.springframework.stereotype.Service;

@Service
public class CreateQuestion {
    private final IQuestionRepo questionRepo;

    public CreateQuestion(IQuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public QuestionResponse create(CreateQuestionRequest request) {
        CategoryQuestion newCategoryQuestion = QuestionMapper.toDomainForCreate(request);
        return QuestionMapper.toQuestionResponse(questionRepo.create(newCategoryQuestion));
    }
}
