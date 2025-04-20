package com.mse.mzad.category.internal.domain.contracts;

import com.mse.mzad.category.internal.domain.models.Category;
import java.util.List;

public interface ICategoryRepo {
    Category create(Category newCategory);
    Category update(Category existCategory);
    Category findById(long categoryId);
    void delete(Category existCategory);
    List<Category> findAll();
}
