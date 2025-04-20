package com.mse.mzad.category.internal.domain.dtos.category;

import lombok.Getter;

@Getter
public class CreateCategoryRequest {
    private String title;
    private Long parentId;
}
