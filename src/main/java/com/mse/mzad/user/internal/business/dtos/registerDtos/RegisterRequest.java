package com.mse.mzad.user.internal.business.dtos.registerDtos;

import com.mse.mzad.user.internal.business.models.AppUser;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
    @NotNull(message = "first name is required")
    private String firstName;

    @NotNull(message = "last name is required")
    private String lastName;

    @NotNull(message = "country code is required")
    @Pattern(regexp = "^\\+\\d{1,4}$", message = "Invalid country code. It must start with '+' followed by 1 to 4 digits.")
    private String countryCode;

    @NotNull(message = "mobile is required")
    @Pattern(regexp = "^[1-9]\\d{1,14}$", message = "Invalid phone number. followed by 2 to 15 digits, must not start with 0")
    private String mobile;

    @NotNull(message = "email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
    private String email;

    @Size(min = 8)
    @NotNull(message = "password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.")
    private String password;

    @NotNull
    private AppUser.UserType userType = AppUser.UserType.CLIENT;

    @Nullable
    private String image;

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

    public AppUser.UserType getUserType() {
        return userType;
    }

    public void setUserType(AppUser.UserType userType) {
        this.userType = userType;
    }

    @Nullable
    public String getImage() {
        return image;
    }

    public void setImage(@Nullable String image) {
        this.image = image;
    }
}
