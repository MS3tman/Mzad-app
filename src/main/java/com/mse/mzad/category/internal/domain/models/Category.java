package com.mse.mzad.category.internal.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long id;
    private String title;
    private Long parentId;
    private String image;

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
}
