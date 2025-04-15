package com.mse.mzad.app.internal.domain.mappers;

import com.mse.mzad.app.internal.domain.dtos.country.CreateRequest;
import com.mse.mzad.app.internal.domain.dtos.country.UpdateRequest;
import com.mse.mzad.app.internal.domain.models.Country;
public class CountryMapper {

    public static Country fromCreateToDomain(CreateRequest request) {
        return new Country(
                null,
                request.getNameAr(),
                request.getNameEn(),
                request.getDialCode(),
                request.getPhoneLength(),
                request.getIsoCode()
        );
    }

    public static Country fromUpdateToDomain(UpdateRequest request) {
        return new Country(
                request.getId(),
                request.getNameAr(),
                request.getNameEn(),
                request.getDialCode(),
                request.getPhoneLength(),
                request.getIsoCode()
        );
    }
}
