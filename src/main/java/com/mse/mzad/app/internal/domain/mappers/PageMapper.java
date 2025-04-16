package com.mse.mzad.app.internal.domain.mappers;

import com.mse.mzad.app.internal.domain.dtos.page.CreateRequest;
import com.mse.mzad.app.internal.domain.dtos.page.UpdateRequest;
import com.mse.mzad.app.internal.domain.models.Page;

public class PageMapper {

    public static Page toDomainForCreate(CreateRequest request) {
        return new Page(
                null,
                request.getSlug(),
                request.getTitle(),
                request.getContent()
        );
    }

    public static Page toDomainForUpdate(UpdateRequest request) {
        return new Page(
                request.getId(),
                request.getSlug(),
                request.getTitle(),
                request.getContent()
        );
    }

}
