package com.mse.mzad.category.internal.domain.dtos.category;

import lombok.Getter;

@Getter
public class UpdateCategoryRequest {
    private long id;
    private String title;
    private Long parentId;
}
