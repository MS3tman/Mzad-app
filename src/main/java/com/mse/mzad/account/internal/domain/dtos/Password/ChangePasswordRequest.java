package com.mse.mzad.account.internal.domain.dtos.Password;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangePasswordRequest {
    private String email;
    private String Password;
    private String otp;
}
