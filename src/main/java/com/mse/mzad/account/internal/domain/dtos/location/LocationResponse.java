package com.mse.mzad.account.internal.domain.dtos.location;

import lombok.Getter;

@Getter
public class LocationResponse {
    private Long id;
    private String address;
    private String country;
    private String city;
    private String postalCode;
    private long userId;

    public LocationResponse(
            Long id,
            String address,
            String country,
            String city,
            String postalCode,
            long userId
    ) {
        this.id = id;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.userId = userId;
    }
}
