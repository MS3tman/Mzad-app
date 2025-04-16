package com.mse.mzad.app.internal.domain.contracts;

import com.mse.mzad.app.internal.domain.models.Page;

import java.util.List;

public interface IPageRepo {
    Page save(Page page);
    Page findById(long id);
    Page update(Page page);
    void delete(Page page);
    List<Page> findAll();
}
