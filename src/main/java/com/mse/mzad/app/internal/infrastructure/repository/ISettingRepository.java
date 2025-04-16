package com.mse.mzad.app.internal.infrastructure.repository;

import com.mse.mzad.app.internal.infrastructure.database.SettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISettingRepository extends JpaRepository<SettingEntity, Long> {
}
