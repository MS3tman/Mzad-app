package com.mse.mzad.app.internal.infrastructure.repository;

import com.mse.mzad.app.internal.infrastructure.database.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPageRepository extends JpaRepository<PageEntity, Long> {
}
