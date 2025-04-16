package com.mse.mzad.app.internal.domain.models;

public class Page {
    private Long id;
    private String slug;
    private String title;
    private String content;

    public Page(Long id, String slug, String title, String content) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
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
