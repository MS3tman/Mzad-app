package com.mse.mzad.app.internal.domain.dtos.page;

public class UpdateRequest {
    private long id;
    private String slug;
    private String title;
    private String content;

    public UpdateRequest(long id, String slug, String title, String content) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
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
