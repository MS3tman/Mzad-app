package com.mse.mzad.account.internal.domain.dtos.user.Login;

import com.mse.mzad.account.internal.domain.models.user.UserType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String countryCode;
    private String mobile;
    private String email;
    private String imagePath;
    private UserType userType;
    private String token;

    public LoginResponse(
            Long id,
            String firstName,
            String lastName,
            String countryCode,
            String mobile,
            String email,
            String imagePath,
            UserType userType,
            String token
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.email = email;
        this.imagePath = imagePath;
        this.userType = userType;
        this.token = token;
    }
}
