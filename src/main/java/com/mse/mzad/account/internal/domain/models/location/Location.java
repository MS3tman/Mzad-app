package com.mse.mzad.account.internal.domain.models.location;

import com.mse.mzad.account.internal.domain.models.user.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {
    private Long id;
    private String address;
    private String country;
    private String city;
    private String postalCode;
    private long userId;

    public Location(
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
