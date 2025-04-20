package com.mse.mzad.app.internal.domain.models;

import lombok.Getter;

@Getter
public class Banner {
    private Long id;
    private String title;
    private String imagePath;

    public Banner(
            Long id,
            String title,
            String imagePath
    ) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;

    }

}
