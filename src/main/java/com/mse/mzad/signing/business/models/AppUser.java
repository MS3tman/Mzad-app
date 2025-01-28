package com.mse.mzad.signing.business.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "Firstname is required")
    @Size(min = 3, max = 10, message = "Firstname must be between 3 and 10 characters")
    private String firstName;

    @Column(nullable = false, length = 50)
    @NotNull(message = "Lastname is required")
    @Size(min = 3, max = 10, message = "Lastname must be between 3 and 10 characters")
    private String lastName;

    @Column(unique = true, nullable = false)
    //@Email(message = "Email should be valid")
    @NotNull(message = "Email is required")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotNull(message = "Country Code is required")
    private String countryCode;

    @NotNull(message = "Mobile is required")
    private String mobile;

    @Column(nullable = false)
    @NotNull(message = "Address is required")
    private String address;
    private String otp;

    @Column(nullable = false)
    private boolean verified = false;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.DENY;
    public enum AccountStatus { ALLOW, DENY}

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
