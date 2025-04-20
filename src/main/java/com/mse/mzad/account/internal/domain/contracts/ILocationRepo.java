package com.mse.mzad.account.internal.domain.contracts;

import com.mse.mzad.account.internal.domain.models.location.Location;

public interface ILocationRepo {
    Location create(Location newLocation);
    Location update(Location location);
    void delete(Location location);
    Location findById(long locationId);
}
