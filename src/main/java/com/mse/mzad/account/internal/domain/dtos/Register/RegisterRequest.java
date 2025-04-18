package com.mse.mzad.account.internal.domain.dtos.Register;

import com.mse.mzad.account.internal.domain.models.user.UserType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String countryCode;
    private String mobile;
    private String email;
    private String password;
    private UserType userType;
}
