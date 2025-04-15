package com.mse.mzad.app.internal.application.commands.country;

import com.mse.mzad.app.internal.domain.contracts.ICountryRepo;
import com.mse.mzad.app.internal.domain.models.Country;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DeleteCountry {
    private final ICountryRepo countryRepo;

    public DeleteCountry(ICountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public String delete(long id) {
        Optional<Country> country = countryRepo.findById(id);
        if(country.isEmpty()) {
            throw new RuntimeException("Country not found");
        }
        return countryRepo.delete(country.get());
    }
}
