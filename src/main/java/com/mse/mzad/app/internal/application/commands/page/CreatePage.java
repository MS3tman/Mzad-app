package com.mse.mzad.app.internal.application.commands.page;

import com.mse.mzad.app.internal.domain.contracts.IPageRepo;
import com.mse.mzad.app.internal.domain.dtos.page.CreateRequest;
import com.mse.mzad.app.internal.domain.mappers.PageMapper;
import com.mse.mzad.app.internal.domain.models.Page;
import org.springframework.stereotype.Service;

@Service
public class CreatePage {
    private final IPageRepo pageRepo;

    public CreatePage(IPageRepo pageRepo) {
        this.pageRepo = pageRepo;
    }

    public Page create(CreateRequest request) {
        Page newPage = PageMapper.toDomainForCreate(request);
        return pageRepo.save(newPage);
    }
}
