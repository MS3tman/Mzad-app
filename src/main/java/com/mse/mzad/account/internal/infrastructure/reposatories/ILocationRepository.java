package com.mse.mzad.account.internal.infrastructure.reposatories;

import com.mse.mzad.account.internal.infrastructure.database.UserLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<UserLocationEntity, Long> {
}
