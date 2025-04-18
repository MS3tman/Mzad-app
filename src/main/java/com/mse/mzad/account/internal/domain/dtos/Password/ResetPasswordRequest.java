package com.mse.mzad.account.internal.domain.dtos.Password;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResetPasswordRequest {
    private String email;
}
