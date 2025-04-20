package com.mse.mzad.category.internal.infrastructure.repositories;

import com.mse.mzad.category.internal.infrastructure.database.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
