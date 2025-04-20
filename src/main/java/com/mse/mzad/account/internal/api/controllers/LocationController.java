package com.mse.mzad.account.internal.api.controllers;

import com.mse.mzad.account.internal.application.command.location.CreateLocation;
import com.mse.mzad.account.internal.application.command.location.UpdateLocation;
import com.mse.mzad.account.internal.application.query.location.DeleteLocation;
import com.mse.mzad.account.internal.domain.dtos.location.CreateLocationRequest;
import com.mse.mzad.account.internal.domain.dtos.location.LocationResponse;
import com.mse.mzad.account.internal.domain.dtos.location.UpdateLocationRequest;
import com.mse.mzad.shared.base.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/location")
public class LocationController {
    @Autowired
    private CreateLocation createLocation;
    @Autowired
    private UpdateLocation updateLocation;
    @Autowired
    private DeleteLocation deleteLocation;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String, LocationResponse>> createLocation(@Valid @RequestBody CreateLocationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(new BaseResponse<>(HttpStatus.CREATED.value(), "User Location is Created", createLocation.create(request)));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponse<String, LocationResponse>> updateLocation(@Valid @RequestBody UpdateLocationRequest request) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Location updated successfully", updateLocation.update(request)));
    }

    @DeleteMapping("/delete/{locationId}")
    public ResponseEntity<BaseResponse<String, Void>> deleteLocation(@PathVariable("locationId") long locationId) {
        deleteLocation.delete(locationId);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Location deleted Successfully", null));
    }
}


