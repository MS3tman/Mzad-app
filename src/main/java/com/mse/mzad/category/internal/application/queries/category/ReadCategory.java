package com.mse.mzad.category.internal.application.queries.category;

import com.mse.mzad.category.internal.domain.contracts.ICategoryRepo;
import com.mse.mzad.category.internal.domain.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadCategory {
    private final ICategoryRepo categoryRepo;

    public ReadCategory(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> all() {
        List<Category> categoryList = categoryRepo.findAll();
        if (categoryList == null) {
            throw new RuntimeException("Not Found Category");
        }
        return categoryList;
    }
}
