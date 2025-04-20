package com.mse.mzad.account.internal.infrastructure.database;

import com.mse.mzad.account.internal.domain.models.user.UserStatus;
import com.mse.mzad.account.internal.domain.models.user.UserType;
import com.mse.mzad.shared.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "First Name Field is required")
    private String firstName;
    @NotNull(message = "Last Name Field is required")
    private String lastName;
    @NotNull(message = "Country Code Field is required")
    private String countryCode;
    @NotNull(message = "Mobile Field is required")
    private String mobile;
    @NotNull(message = "Email Field is required")
    private String email;
    @NotNull(message = "Password Field is required")
    private String password;
    private String otp;
    private boolean verified = false;
    @NotNull(message = "User Type Field is required")
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.CLIENT;
    private String imagePath;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus = UserStatus.DENY;
    @OneToMany(mappedBy = "user")
    private List<UserLocationEntity> locations;

    public UserEntity() {}

    public UserEntity(
            String firstName,
            String lastName,
            String countryCode,
            String mobile,
            String email,
            String password,
            String otp,
            UserType userType
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.otp = otp;
        this.userType = userType;
    }

    public UserEntity(
            long id,
            String firstName,
            String lastName,
            String countryCode,
            String mobile,
            String email,
            String password,
            String otp,
            boolean verified,
            UserType userType,
            String imagePath,
            UserStatus userStatus
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.otp = otp;
        this.verified = verified;
        this.userType = userType;
        this.imagePath = imagePath;
        this.userStatus = userStatus;
    }
}
