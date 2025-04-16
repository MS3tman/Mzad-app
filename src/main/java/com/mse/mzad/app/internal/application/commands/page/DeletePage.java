package com.mse.mzad.app.internal.application.commands.page;

import com.mse.mzad.app.internal.domain.contracts.IPageRepo;
import com.mse.mzad.app.internal.domain.models.Page;
import org.springframework.stereotype.Service;

@Service
public class DeletePage {
    private final IPageRepo pageRepo;

    public DeletePage(IPageRepo pageRepo) {
        this.pageRepo = pageRepo;
    }

    public void delete(long id) {
        Page page = pageRepo.findById(id);
        pageRepo.delete(page);
    }
}
