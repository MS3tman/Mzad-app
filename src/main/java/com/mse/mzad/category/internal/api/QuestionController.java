package com.mse.mzad.category.internal.api;

import com.mse.mzad.category.internal.application.commands.categoryQuestion.CreateQuestion;
import com.mse.mzad.category.internal.application.commands.categoryQuestion.UpdateQuestion;
import com.mse.mzad.category.internal.application.queries.categoryQuestion.DeleteQuestion;
import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.CreateQuestionRequest;
import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.QuestionResponse;
import com.mse.mzad.category.internal.domain.dtos.categoryQuestion.UpdateQuestionRequest;
import com.mse.mzad.shared.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category/question")
public class QuestionController {
    @Autowired
    private CreateQuestion createQuestion;
    @Autowired
    private UpdateQuestion updateQuestion;
    @Autowired
    private DeleteQuestion deleteQuestion;

    @PostMapping("/create")
    private ResponseEntity<BaseResponse<String, QuestionResponse>> create(@RequestBody CreateQuestionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponse<>(HttpStatus.CREATED.value(), "Question Created Successfully", createQuestion.create(request)));
    }

    @PutMapping("/update")
    private ResponseEntity<BaseResponse<String, QuestionResponse>> update(@RequestBody UpdateQuestionRequest request) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Question Updated Successfully", updateQuestion.update(request)));
    }

    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<BaseResponse<String, Void>> delete(@PathVariable("questionId") long questionId ) {
        deleteQuestion.delete(questionId);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Question Deleted Successfully", null));
    }
}
