//package com.mse.mzad.account.internal.api.controllers;
//
//import com.mse.mzad.shared.base.BaseResponse;
//import com.mse.mzad.account.internal.domain.dtos.locationDtos.CreateLocationRequest;
//import com.mse.mzad.account.internal.domain.dtos.locationDtos.UpdateLocationRequest;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/user/location")
//public class LocationController {
//    @Autowired
//    private CreateLocation createLocation;
//    @Autowired
//    private UpdateLocation updateLocation;
//    @Autowired
//    private DeleteLocation deleteLocation;
//
//    @PostMapping("/create")
//    public ResponseEntity<BaseResponse<String, Void>> createLocation(@Valid @RequestBody CreateLocationRequest createLocationRequest) {
//        createLocation.create(createLocationRequest);
//        return ResponseEntity.status(HttpStatus.CREATED.value()).body(new BaseResponse<>(HttpStatus.CREATED.value(), "User Location is Created", null));
//    }
//
//    @PutMapping("/update/{locationId}")
//    public ResponseEntity<BaseResponse<String, UserLocation>> updateLocation(@Valid @RequestBody UpdateLocationRequest updateLocationRequest) {
//        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Location updated successfully", updateLocation.update(updateLocationRequest)));
//    }
//
//    @DeleteMapping("/delete/{locationId}")
//    public ResponseEntity<BaseResponse<String, Void>> deleteLocation(@PathVariable("locationId") long locationId) {
//        deleteLocation.delete(locationId);
//        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Location deleted Successfully", null));
//    }
//}
//
//
