package com.mse.mzad.account.internal.application.command.location;

import com.mse.mzad.account.internal.domain.contracts.ILocationRepo;
import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.dtos.location.CreateLocationRequest;
import com.mse.mzad.account.internal.domain.dtos.location.LocationResponse;
import com.mse.mzad.account.internal.domain.mappers.location.LocationMapper;
import com.mse.mzad.account.internal.domain.models.location.Location;
import com.mse.mzad.account.internal.domain.models.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CreateLocation {
    private final ILocationRepo locationRepo;
    private final IUserRepo userRepo;

    public CreateLocation(ILocationRepo locationRepo, IUserRepo userRepo) {
        this.locationRepo = locationRepo;
        this.userRepo = userRepo;
    }

    public LocationResponse create(CreateLocationRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User existUser = userRepo.findByEmail(email);
        Location newLocation = LocationMapper.toDomainForCreate(request, existUser.getUserData().getId());
        return LocationMapper.toDTOForResponse(locationRepo.create(newLocation));
    }
}
