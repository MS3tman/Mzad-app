package com.mse.mzad.user.internal.business.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_locations")
public class UserLocation extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "AppUser is required")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "country is required")
    private String country;

    @NotBlank(message = "city is required")
    private String city;

    @NotBlank(message = "postal code is required")
    @Column(name = "postal_code")
    private String postalCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

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
