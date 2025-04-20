package com.mse.mzad.category.internal.domain.dtos.category;

import lombok.Getter;

@Getter
public class CategoryResponse {
    private long id;
    private String title;
    private Long parentId;
    private String image;

    public CategoryResponse(
            long id,
            String title,
            Long parentId,
            String image
    ) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
        this.image = image;
    }
}
