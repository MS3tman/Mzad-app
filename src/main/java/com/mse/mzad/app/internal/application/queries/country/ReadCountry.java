package com.mse.mzad.app.internal.application.queries.country;

import com.mse.mzad.app.internal.domain.contracts.ICountryRepo;
import com.mse.mzad.app.internal.domain.models.Country;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReadCountry {
    private final ICountryRepo countryRepo;

    public ReadCountry(ICountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    public List<Country> list() {
        List<Country> countryList = countryRepo.getCountries();
        if(countryList == null) {
            throw new RuntimeException("Not found Countries");
        }
        return countryList;
    }
}
