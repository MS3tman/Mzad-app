package com.mse.mzad.app.internal.domain.models.banner;

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

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImagePath() {
        return imagePath;
    }
}
