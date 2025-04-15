package com.mse.mzad.user.internal.api.controllers;

import com.mse.mzad.user.internal.business.dtos.BaseResponse;
import com.mse.mzad.user.internal.business.dtos.locationDtos.CreateLocationRequest;
import com.mse.mzad.user.internal.business.dtos.locationDtos.UpdateLocationRequest;
import com.mse.mzad.user.internal.business.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String, Void>> createLocation(@Valid @RequestBody CreateLocationRequest createLocationRequest) {
        return locationService.create(createLocationRequest);
    }

    @PutMapping("/update/{locationId}")
    public ResponseEntity<BaseResponse<String, Void>> updateLocation(@Valid @RequestBody UpdateLocationRequest updateLocationRequest, @PathVariable("locationId") long locationId) {
        return locationService.update(updateLocationRequest, locationId);
    }

    @DeleteMapping("/delete/{locationId}")
    public ResponseEntity<BaseResponse<String, Void>> deleteLocation(@PathVariable("locationId") long locationId) {
        return locationService.delete(locationId);
    }
}


