package com.mse.mzad.user.internal.business.services;

import com.mse.mzad.shared.base.BaseResponse;
import com.mse.mzad.user.internal.business.dtos.locationDtos.CreateLocationRequest;
import com.mse.mzad.user.internal.business.dtos.locationDtos.UpdateLocationRequest;
import com.mse.mzad.user.internal.business.mappers.LocationMapper;
import com.mse.mzad.user.internal.business.models.AppUser;
import com.mse.mzad.user.internal.business.models.UserLocation;
import com.mse.mzad.user.internal.infrastructure.reposatories.ILocationRepository;
import com.mse.mzad.user.internal.infrastructure.reposatories.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LocationService {
    private final ILocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final IUserRepository userRepository;

    public LocationService(ILocationRepository locationRepository, LocationMapper locationMapper, IUserRepository userRepository) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
        this.userRepository = userRepository;
    }

    public ResponseEntity<BaseResponse<String, Void>> create(CreateLocationRequest createLocationRequest) {
        UserLocation newUserLocation = locationMapper.toEntity(createLocationRequest);
        locationRepository.save(newUserLocation);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.CREATED.value(), "User Location is Created", null));
    }

    public ResponseEntity<BaseResponse<String, Void>> update(UpdateLocationRequest updateLocationRequest, long locationId) {
        Optional<UserLocation> userLocationOptional = locationRepository.findById(locationId);
        if(userLocationOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Location not found", null));
        }
        UserLocation existUserLocation = locationMapper.toEntity(updateLocationRequest, locationId);
        locationRepository.save(existUserLocation);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.ACCEPTED.value(), "Location updated successfully", null));
    }

    public ResponseEntity<BaseResponse<String, Void>> delete(long locationId) {
        Optional<UserLocation> userLocationOptional = locationRepository.findById(locationId);
        if(userLocationOptional.isPresent()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            AppUser appUser = userRepository.getByEmail(authentication.getName());
            UserLocation userLocation = userLocationOptional.get();
            if(appUser.getId() == userLocation.getAppUser().getId()) {
                locationRepository.delete(userLocation);
                return ResponseEntity.ok(new BaseResponse<>(HttpStatus.ACCEPTED.value(), "Location deleted Successfully", null));
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new BaseResponse<>(HttpStatus.FORBIDDEN.value(), "You are not authorized to delete this location", null));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Location Not Exist", null));
    }

}
