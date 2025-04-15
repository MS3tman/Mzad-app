package com.mse.mzad.app.internal.application.commands.country;

import com.mse.mzad.app.internal.domain.dtos.country.CreateRequest;
import com.mse.mzad.app.internal.domain.mappers.CountryMapper;
import com.mse.mzad.app.internal.domain.models.Country;
import com.mse.mzad.app.internal.domain.contracts.ICountryRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CreateCountry {
    private final ICountryRepo countryRepo;

    public CreateCountry(ICountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public Country create( CreateRequest createRequest) {
        Optional<Country> existCountry = countryRepo.findByDialCode(createRequest.getDialCode());
        if(existCountry.isPresent()) {
            throw new RuntimeException("country exist");
        }
        Country country = CountryMapper.fromCreateToDomain(createRequest);
        return countryRepo.CreateCountry(country);
    }
}
