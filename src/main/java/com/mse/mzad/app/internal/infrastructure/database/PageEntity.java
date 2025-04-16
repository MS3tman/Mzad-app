package com.mse.mzad.app.internal.infrastructure.database;

import com.mse.mzad.shared.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pages")
public class PageEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "slug is required")
    private String slug;
    @NotNull(message = "title is required")
    private String title;
    @NotNull(message = "content is required")
    @Column(columnDefinition = "TEXT")
    private String content;

    public PageEntity() {}

    public PageEntity(
            String slug,
            String title,
            String content
    ) {
        this.slug = slug;
        this.title = title;
        this.content = content;
    };

    public PageEntity(
            Long id,
            String slug,
            String title,
            String content
    ) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.content = content;
    };

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
