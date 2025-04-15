package com.mse.mzad.user.internal.business.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class AppUser extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "appUser")
    private List<UserLocation> userLocations;

    @Column(name = "first_name")
    @NotNull(message = "first name is required")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "last name is required")
    private String lastName;

    @Column(name = "country_code")
    @NotNull(message = "country code is required")
    @Pattern(regexp = "^\\+\\d{1,4}$", message = "Invalid country code. It must start with '+' followed by 1 to 4 digits.")
    private String countryCode;

    @NotNull(message = "mobile is required")
    @Column(unique = true)
    @Pattern(regexp = "^[1-9]\\d{1,14}$", message = "Invalid phone number. followed by 2 to 15 digits, must not start with 0")
    private String mobile;

    @NotNull(message = "email is required")
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
    private String email;

    @Size(min = 8)
    @NotNull(message = "password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.")
    private String password;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private UserType userType = UserType.CLIENT;

    @Nullable
    private String image;

    @Nullable
    private String otp;

    @Nullable
    private boolean verified = false;

    @Column(name = "package_id")
    private long packageId;

    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    @NotNull
    private AccountStatus accountStatus = AccountStatus.DENY;

    public enum UserType {
        CLIENT,
        INSTITUTION
    }

    public enum AccountStatus {
        ALLOW,
        DENY
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPackageId() {
        return packageId;
    }

    public void setPackageId(long packageId) {
        this.packageId = packageId;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
