package com.mse.mzad.account.internal.application.command.location;

import com.mse.mzad.account.internal.domain.contracts.ILocationRepo;
import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.dtos.location.LocationResponse;
import com.mse.mzad.account.internal.domain.dtos.location.UpdateLocationRequest;
import com.mse.mzad.account.internal.domain.mappers.location.LocationMapper;
import com.mse.mzad.account.internal.domain.models.location.Location;
import com.mse.mzad.account.internal.domain.models.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UpdateLocation {
    private final ILocationRepo locationRepo;
    private final IUserRepo userRepo;

    public UpdateLocation(ILocationRepo locationRepo, IUserRepo userRepo) {
        this.locationRepo = locationRepo;
        this.userRepo = userRepo;
    }

    public LocationResponse update(UpdateLocationRequest request) {
        Location existLocation = locationRepo.findById(request.getId());
        if(existLocation == null) {
            throw new RuntimeException("Location not Found");
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User existUser = userRepo.findByEmail(email);
        if(existLocation.getUserId() != existUser.getUserData().getId()) {
            throw new RuntimeException("Don't have permission For update this location");
        }
        Location location = LocationMapper.toDomainForUpdate(request, existLocation.getUserId());
        return LocationMapper.toDTOForResponse(locationRepo.update(location));
    }
}
