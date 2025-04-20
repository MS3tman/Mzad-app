package com.mse.mzad.account.internal.application.command.user;

import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.dtos.user.Register.VerifyEmailRequest;
import com.mse.mzad.account.internal.domain.models.user.User;
import com.mse.mzad.account.internal.domain.models.user.UserStatus;
import org.springframework.stereotype.Service;

@Service
public class VerifyEmailForRegister {
    private final IUserRepo userRepo;

    public VerifyEmailForRegister(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void verifyEmail(VerifyEmailRequest request) {
        User existUser = userRepo.findByEmail(request.getEmail());
        if(existUser == null) {
            throw new RuntimeException("Email Not Found");
        }
        if(!request.getEmail().equals(existUser.getEmail().getValue()) || !existUser.getUserControl().getOtp().equals(request.getOtp())) {
            throw new RuntimeException("Email or OTP is Invalid");
        }
        existUser.getUserControl().setVerified(true);
        existUser.getUserControl().setOtp(null);
        existUser.getUserControl().setUserStatus(UserStatus.ALLOW);
        userRepo.update(existUser);
    }
}
