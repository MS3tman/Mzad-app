package com.mse.mzad.account.internal.domain.models.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserData {
    private Long id;
    private String firstName;
    private String lastName;
    private String countryCode;
    private String mobile;
    private UserType userType;

    public UserData(
            Long id,
            String firstName,
            String lastName,
            String countryCode,
            String mobile,
            UserType userType
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.userType = userType;
    }

}
