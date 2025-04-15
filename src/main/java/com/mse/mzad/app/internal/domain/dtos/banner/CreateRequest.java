package com.mse.mzad.app.internal.domain.dtos.banner;

import org.springframework.web.multipart.MultipartFile;

public class CreateRequest {
    private String title;
    private MultipartFile image;

    public CreateRequest(
            String title,
            MultipartFile image
    ) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public MultipartFile getImage() {
        return image;
    }
}
