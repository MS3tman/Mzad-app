package com.mse.mzad.account.internal.domain.mappers;

import com.mse.mzad.account.internal.domain.dtos.Register.RegisterRequest;
import com.mse.mzad.account.internal.domain.models.user.*;

public class RegisterMapper {

    public static User toDomainForRegister(RegisterRequest request, String otp) {
        UserData userData = new UserData(
                null,
                request.getFirstName(),
                request.getLastName(),
                request.getCountryCode(),
                request.getMobile(),
                request.getUserType()
        );

        return new User(
                userData,
                new Email(request.getEmail()),
                new Password(request.getPassword()),
                new UserControl(otp),
                null
        );
    }

}
