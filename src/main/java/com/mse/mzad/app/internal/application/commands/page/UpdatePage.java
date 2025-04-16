package com.mse.mzad.app.internal.application.commands.page;

import com.mse.mzad.app.internal.domain.contracts.IPageRepo;
import com.mse.mzad.app.internal.domain.dtos.page.UpdateRequest;
import com.mse.mzad.app.internal.domain.mappers.PageMapper;
import com.mse.mzad.app.internal.domain.models.Page;
import org.springframework.stereotype.Service;

@Service
public class UpdatePage {
    private final IPageRepo pageRepo;

    public UpdatePage(IPageRepo pageRepo) {
        this.pageRepo = pageRepo;
    }

    public Page update(UpdateRequest request) {
        pageRepo.findById(request.getId());
        Page page = PageMapper.toDomainForUpdate(request);
        return pageRepo.update(page);
    }
}
