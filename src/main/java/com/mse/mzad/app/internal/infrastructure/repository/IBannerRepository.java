package com.mse.mzad.app.internal.infrastructure.repository;

import com.mse.mzad.app.internal.infrastructure.database.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBannerRepository extends JpaRepository<BannerEntity, Long> {
}
