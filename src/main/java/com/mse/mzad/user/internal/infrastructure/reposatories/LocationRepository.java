package com.mse.mzad.user.internal.infrastructure.reposatories;

import com.mse.mzad.user.internal.business.models.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<UserLocation, Long> {
}
