package com.mse.mzad.app.internal.infrastructure.mappers;

import com.mse.mzad.app.internal.domain.models.Country;
import com.mse.mzad.app.internal.infrastructure.database.CountryEntity;

public class CountryMapper {

    public static CountryEntity toEntityForCreate(Country country) {
        return new CountryEntity(
                country.getNameAr(),
                country.getNameEn(),
                country.getDialCode(),
                country.getPhoneLength(),
                country.getIsoCode()
        );
    }

    public static CountryEntity toEntityForUpdate(Country country) {
        return new CountryEntity(
                country.getId(),
                country.getNameAr(),
                country.getNameEn(),
                country.getDialCode(),
                country.getPhoneLength(),
                country.getIsoCode()
        );
    }

    public static Country toDomain(CountryEntity countryEntity) {
        return new Country(
                countryEntity.getId(),
                countryEntity.getNameAr(),
                countryEntity.getNameEn(),
                countryEntity.getDialCode(),
                countryEntity.getPhoneLength(),
                countryEntity.getIsoCode()
        );
    }

}
