package com.mse.mzad.app.internal.domain.contracts;

import com.mse.mzad.app.internal.domain.models.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryRepo {
    Country CreateCountry(Country country);
    Country updateCountry(Country country);
    Optional<Country> findByDialCode(String dialCode);
    Optional<Country> findById(long id);
    String delete(Country country);
    List<Country> getCountries();
}
