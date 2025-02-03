package com.mse.mzad.signing.business.dtos;

import jakarta.validation.constraints.NotNull;

public class ForgetPasswordRequest {
    @NotNull
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
