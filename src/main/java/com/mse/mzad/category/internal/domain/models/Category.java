package com.mse.mzad.category.internal.domain.models;

import com.mse.mzad.category.internal.domain.models.categoryQuestion.CategoryQuestion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category {
    private Long id;
    private String title;
    private Long parentId;
    private String image;
    private List<CategoryQuestion> questions;

    public Category(
            Long id,
            String title,
            Long parentId,
            String image
    ) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.image = image;
    }

    public Category(
            Long id,
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
