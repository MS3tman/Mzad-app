package com.mse.mzad.account.internal.domain.models.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserControl {
    private String otp;
    private boolean verified;
    private UserStatus userStatus;

    public UserControl(String otp) {
        this.otp = otp;
    }

    public UserControl(String otp, boolean verified, UserStatus userStatus) {
        this.otp = otp;
        this.verified = verified;
        this.userStatus = userStatus;
    }

}
