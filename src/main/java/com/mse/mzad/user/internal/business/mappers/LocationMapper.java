package com.mse.mzad.user.internal.business.mappers;

import com.mse.mzad.user.internal.business.dtos.locationDtos.CreateLocationRequest;
import com.mse.mzad.user.internal.business.dtos.locationDtos.UpdateLocationRequest;
import com.mse.mzad.user.internal.business.models.AppUser;
import com.mse.mzad.user.internal.business.models.UserLocation;
import com.mse.mzad.user.internal.infrastructure.reposatories.LocationRepository;
import com.mse.mzad.user.internal.infrastructure.reposatories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LocationMapper {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private UserRepository userRepository;

    public UserLocation toEntity(CreateLocationRequest createLocationRequest) {
        UserLocation userLocation = new UserLocation();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser existUser = userRepository.getByEmail(authentication.getName());
        userLocation.setAppUser(existUser);
        userLocation.setAddress(createLocationRequest.getAddress());
        userLocation.setCountry(createLocationRequest.getCountry());
        userLocation.setCity(createLocationRequest.getCity());
        userLocation.setPostalCode(createLocationRequest.getPostalCode());
        return userLocation;
    }

    public UserLocation toEntity(UpdateLocationRequest updateLocationRequest, Long locationId) {
        Optional<UserLocation> userLocationOptional = locationRepository.findById(locationId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = userRepository.getByEmail(authentication.getName());
        if(userLocationOptional.isEmpty()) {
            throw new IllegalArgumentException("Location not found");
        }
        UserLocation existingLocation = userLocationOptional.get();
        if (existingLocation.getAppUser().getId() != appUser.getId()) {
            throw new IllegalArgumentException("You are not authorized to update this location.");
        }
        existingLocation.setAddress(updateLocationRequest.getAddress());
        existingLocation.setCountry(updateLocationRequest.getCountry());
        existingLocation.setCity(updateLocationRequest.getCity());
        existingLocation.setPostalCode(updateLocationRequest.getPostalCode());
        return existingLocation;
    }
}
