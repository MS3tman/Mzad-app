package com.mse.mzad.account.internal.infrastructure.reposatories;

import com.mse.mzad.account.internal.domain.contracts.ILocationRepo;
import com.mse.mzad.account.internal.domain.models.location.Location;
import com.mse.mzad.account.internal.infrastructure.database.UserEntity;
import com.mse.mzad.account.internal.infrastructure.database.UserLocationEntity;
import com.mse.mzad.account.internal.infrastructure.mappers.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationRepository implements ILocationRepo {
    @Autowired
    private ILocationRepository locationRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Location create(Location newLocation) {
        UserEntity userEntity = userRepository.findById(newLocation.getUserId())
                .orElseThrow(() -> new RuntimeException("User with ID " + newLocation.getUserId() + " not found"));
        UserLocationEntity newUserLocationEntity = LocationMapper.toEntityForCreate(newLocation, userEntity);
        UserLocationEntity savedUserLocationEntity = locationRepository.save(newUserLocationEntity);
        return LocationMapper.toDomain(savedUserLocationEntity);
    }

    @Override
    public Location update(Location existLocation) {
        UserEntity userEntity = userRepository.findById(existLocation.getUserId())
                .orElseThrow(() -> new RuntimeException("User with ID " + existLocation.getUserId() + " not found"));
        UserLocationEntity existUserLocationEntity = LocationMapper.toEntityForUpdate(existLocation, userEntity);
        UserLocationEntity savedUserLocationEntity = locationRepository.save(existUserLocationEntity);
        return LocationMapper.toDomain(savedUserLocationEntity);
    }

    @Override
    public void delete(Location existLocation) {
        UserEntity userEntity = userRepository.findById(existLocation.getUserId())
                .orElseThrow(() -> new RuntimeException("User with ID " + existLocation.getUserId() + " not found"));
        UserLocationEntity existUserLocationEntity = LocationMapper.toEntityForUpdate(existLocation, userEntity);
        locationRepository.delete(existUserLocationEntity);
    }

    @Override
    public Location findById(long locationId) {
        UserLocationEntity existUserLocationEntity = locationRepository.findById(locationId).orElseThrow(() -> new RuntimeException("Location not found"));
        return LocationMapper.toDomain(existUserLocationEntity);
    }
}
