package com.mse.mzad.account.internal.application.query.location;

import com.mse.mzad.account.internal.domain.contracts.ILocationRepo;
import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.models.location.Location;
import com.mse.mzad.account.internal.domain.models.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DeleteLocation {
    private final ILocationRepo locationRepo;
    private final IUserRepo userRepo;

    public DeleteLocation(ILocationRepo locationRepo, IUserRepo userRepo) {
        this.locationRepo = locationRepo;
        this.userRepo = userRepo;
    }

    public void delete(long locationId) {
        Location existLocation = locationRepo.findById(locationId);
        if (existLocation == null) {
            throw new RuntimeException("Location not found");
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User existUser = userRepo.findByEmail(email);
        if(existLocation.getUserId() != existUser.getUserData().getId()) {
            throw new RuntimeException("Don't have permission For delete this location");
        }
        locationRepo.delete(existLocation);
    }
}
