package com.mse.mzad.account.internal.domain.dtos.user.Register;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VerifyEmailRequest {
    private String email;
    private String otp;
}
