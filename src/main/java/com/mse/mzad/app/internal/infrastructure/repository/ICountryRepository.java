package com.mse.mzad.app.internal.infrastructure.repository;

import com.mse.mzad.app.internal.infrastructure.database.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICountryRepository extends JpaRepository<CountryEntity, Long> {
    Optional<CountryEntity> findByDialCode(String dialCode);
}
