package com.mse.mzad.category.internal.domain.dtos.category;

import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryResponse {
    private long id;
    private String title;
    private Long parentId;
    private String image;
    private List<CategoryQuestion> questions;

    public CategoryResponse(
            long id,
            String title,
            Long parentId,
            String image,
            List<CategoryQuestion> questions
    ) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.image = image;
        this.questions = questions;
    }
}
