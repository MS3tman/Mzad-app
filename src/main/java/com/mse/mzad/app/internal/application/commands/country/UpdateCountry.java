package com.mse.mzad.app.internal.application.commands.country;

import com.mse.mzad.app.internal.domain.contracts.ICountryRepo;
import com.mse.mzad.app.internal.domain.dtos.country.UpdateRequest;
import com.mse.mzad.app.internal.domain.mappers.CountryMapper;
import com.mse.mzad.app.internal.domain.models.Country;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UpdateCountry {
    private final ICountryRepo countryRepo;

    public UpdateCountry(ICountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public Country update(UpdateRequest updateRequest) {
        Optional<Country> existCountry = countryRepo.findById(updateRequest.getId());
        if(existCountry.isEmpty()) {
            throw  new RuntimeException("Country not found");
        }
        Country country = CountryMapper.fromUpdateToDomain(updateRequest);
        return countryRepo.updateCountry(country);
    }
}
