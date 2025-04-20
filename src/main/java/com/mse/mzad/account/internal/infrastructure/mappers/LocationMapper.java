package com.mse.mzad.account.internal.infrastructure.mappers;

import com.mse.mzad.account.internal.domain.models.location.Location;
import com.mse.mzad.account.internal.infrastructure.database.UserEntity;
import com.mse.mzad.account.internal.infrastructure.database.UserLocationEntity;

public class LocationMapper {

    public static UserLocationEntity toEntityForCreate(Location newLocation, UserEntity userEntity) {
        return new UserLocationEntity(
            newLocation.getAddress(),
            newLocation.getCountry(),
            newLocation.getCity(),
            newLocation.getPostalCode(),
            userEntity
        );
    }

    public static UserLocationEntity toEntityForUpdate(Location existlocation, UserEntity userEntity) {
        return new UserLocationEntity(
                existlocation.getId(),
                existlocation.getAddress(),
                existlocation.getCountry(),
                existlocation.getCity(),
                existlocation.getPostalCode(),
                userEntity
        );
    }

    public static Location toDomain(UserLocationEntity userLocationEntity) {
        return new Location(
            userLocationEntity.getId(),
            userLocationEntity.getAddress(),
            userLocationEntity.getCountry(),
            userLocationEntity.getCity(),
            userLocationEntity.getPostalCode(),
            userLocationEntity.getUser().getId()
        );
    }
}
