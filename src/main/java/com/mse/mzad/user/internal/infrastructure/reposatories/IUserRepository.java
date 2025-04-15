package com.mse.mzad.user.internal.infrastructure.reposatories;

import com.mse.mzad.user.internal.business.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<AppUser, Long> {
    AppUser getByEmail(String email);
}
