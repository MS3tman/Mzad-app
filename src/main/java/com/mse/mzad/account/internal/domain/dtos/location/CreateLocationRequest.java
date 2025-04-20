package com.mse.mzad.account.internal.domain.dtos.location;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateLocationRequest {
    private String address;
    private String country;
    private String city;
    private String postalCode;
}
