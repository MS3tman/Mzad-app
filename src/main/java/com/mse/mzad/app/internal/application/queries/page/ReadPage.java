package com.mse.mzad.app.internal.application.queries.page;

import com.mse.mzad.app.internal.domain.contracts.IPageRepo;
import com.mse.mzad.app.internal.domain.models.Page;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReadPage {
    private final IPageRepo pageRepo;

    public ReadPage(IPageRepo pageRepo) {
        this.pageRepo = pageRepo;
    }

    public List<Page> all() {
        return pageRepo.findAll();
    }
}
