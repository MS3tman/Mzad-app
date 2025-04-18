package com.mse.mzad.account.internal.domain.dtos.Login;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    private String email;
    private String password;
}
