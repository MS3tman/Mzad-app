package com.mse.mzad.app.internal.domain.dtos.page;

public class CreateRequest {
    private String slug;
    private String title;
    private String content;

    public CreateRequest(String slug, String title, String content) {
        this.slug = slug;
        this.title = title;
        this.content = content;
    }

    public String getSlug() {
        return slug;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
