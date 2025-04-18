package com.mse.mzad.account.internal.infrastructure.reposatories;

import com.mse.mzad.account.internal.infrastructure.database.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
