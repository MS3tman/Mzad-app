package com.mse.mzad.app.internal.infrastructure.mappers;

import com.mse.mzad.app.internal.domain.models.Page;
import com.mse.mzad.app.internal.infrastructure.database.PageEntity;

public class PageMapper {

    public static PageEntity toEntityForCreate(Page page) {
        return new PageEntity(
                page.getSlug(),
                page.getTitle(),
                page.getContent()
        );
    }

    public static PageEntity toEntityForUpdate(Page page) {
        return new PageEntity(
                page.getId(),
                page.getSlug(),
                page.getTitle(),
                page.getContent()
        );
    }

    public static Page toDomain(PageEntity pageEntity) {
        return new Page(
                pageEntity.getId(),
                pageEntity.getSlug(),
                pageEntity.getTitle(),
                pageEntity.getContent()
        );
    }
}
