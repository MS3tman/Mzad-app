package com.mse.mzad.user.internal.business.dtos.locationDtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class UpdateLocationRequest {
    @NotBlank
    private String address;

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    @Column(name = "postal_code")
    private String postalCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
