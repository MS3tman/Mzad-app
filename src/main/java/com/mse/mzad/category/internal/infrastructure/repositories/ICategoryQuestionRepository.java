package com.mse.mzad.category.internal.infrastructure.repositories;

import com.mse.mzad.category.internal.infrastructure.database.CategoryQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryQuestionRepository extends JpaRepository<CategoryQuestionEntity, Long> {
}
