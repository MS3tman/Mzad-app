package com.mse.mzad.app.internal.infrastructure.repository;

import com.mse.mzad.app.internal.domain.contracts.ICountryRepo;
import com.mse.mzad.app.internal.domain.models.Country;
import com.mse.mzad.app.internal.infrastructure.database.CountryEntity;
import com.mse.mzad.app.internal.infrastructure.mappers.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CountryRepository implements ICountryRepo {
    @Autowired
    private ICountryRepository countryRepository;

    @Override
    public Country CreateCountry(Country country) {
        CountryEntity countryEntity = CountryMapper.toEntityForCreate(country);
        CountryEntity newCountry = countryRepository.save(countryEntity);
        return CountryMapper.toDomain(newCountry);
    }

    @Override
    public Country updateCountry(Country country) {
        CountryEntity countryEntity = CountryMapper.toEntityForUpdate(country);
        CountryEntity newCountry = countryRepository.save(countryEntity);
        return CountryMapper.toDomain(newCountry);
    }

    @Override
    public Optional<Country> findByDialCode(String dialCode) {
        Optional<CountryEntity> countryEntity = countryRepository.findByDialCode(dialCode);
        if(countryEntity.isPresent()) {
            Country country = CountryMapper.toDomain(countryEntity.get());
            return Optional.of(country);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Country> findById(long id) {
        Optional<CountryEntity> existCountryEntity = countryRepository.findById(id);
        if(existCountryEntity.isPresent()) {
            Country existCountry = CountryMapper.toDomain(existCountryEntity.get());
            return Optional.of(existCountry);
        }
        return Optional.empty();
    }

    @Override
    public String delete(Country country) {
        CountryEntity countryEntity = CountryMapper.toEntityForUpdate(country);
        countryRepository.delete(countryEntity);
        return "Country Deleted Successfully";
    }

    @Override
    public List<Country> getCountries() {
       List<CountryEntity> countryEntityList = countryRepository.findAll();
       List<Country> countryList = new ArrayList<>();
       for (CountryEntity countryEntity : countryEntityList) {
           countryList.add(CountryMapper.toDomain(countryEntity));
       }
        return countryList;
    }
}
