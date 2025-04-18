package com.mse.mzad.account.internal.domain.mappers;

import com.mse.mzad.account.internal.domain.dtos.Login.LoginResponse;
import com.mse.mzad.account.internal.domain.models.user.User;

public class LoginMapper {

    public static LoginResponse toLoginResponse(User user, String token) {
        return new LoginResponse(
            user.getUserData().getId(),
            user.getUserData().getFirstName(),
            user.getUserData().getLastName(),
            user.getUserData().getCountryCode(),
            user.getUserData().getMobile(),
            user.getEmail().getValue(),
            user.getUserImage().getImagePath(),
            user.getUserData().getUserType(),
            token
        );
    }
}
