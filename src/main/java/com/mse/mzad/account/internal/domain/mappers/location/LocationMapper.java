package com.mse.mzad.account.internal.domain.mappers.location;

import com.mse.mzad.account.internal.domain.dtos.location.CreateLocationRequest;
import com.mse.mzad.account.internal.domain.dtos.location.LocationResponse;
import com.mse.mzad.account.internal.domain.dtos.location.UpdateLocationRequest;
import com.mse.mzad.account.internal.domain.models.location.Location;

public class LocationMapper {

    public static Location toDomainForCreate(CreateLocationRequest request, long userId) {
        return  new Location(
                null,
             request.getAddress(),
             request.getCountry(),
             request.getCity(),
             request.getPostalCode(),
             userId
        );
    }

    public static Location toDomainForUpdate(UpdateLocationRequest request, long userId) {
        return new Location(
                request.getId(),
                request.getAddress(),
                request.getCountry(),
                request.getCity(),
                request.getPostalCode(),
                userId
        );
    }

    public static LocationResponse toDTOForResponse(Location location) {
        return new LocationResponse(
            location.getId(),
            location.getAddress(),
            location.getCountry(),
            location.getCity(),
            location.getPostalCode(),
            location.getUserId()
        );
    }
}
