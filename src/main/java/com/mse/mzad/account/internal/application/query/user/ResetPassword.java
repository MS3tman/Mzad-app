package com.mse.mzad.account.internal.application.query.user;

import com.mse.mzad.account.internal.domain.contracts.IEmailService;
import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.dtos.Password.ResetPasswordRequest;
import com.mse.mzad.account.internal.domain.models.user.User;
import com.mse.mzad.account.internal.domain.models.user.UserStatus;
import org.springframework.stereotype.Service;

@Service
public class ResetPassword {
    private final IUserRepo userRepo;
    private final IEmailService emailService;

    public ResetPassword(IUserRepo userRepo, IEmailService emailService) {
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    public void verifyEmail(ResetPasswordRequest request) {
        User existUser = userRepo.findByEmail(request.getEmail());
        if(existUser == null) {
            throw new RuntimeException("Email not Exist");
        }
        if(!existUser.getUserControl().isVerified()) {
            throw new RuntimeException("Account not Verified, go to verified your Account");
        }
        if(existUser.getUserControl().getUserStatus() == UserStatus.DENY) {
            throw new RuntimeException("Account Deny");
        }
        String otp = emailService.generateOTP();
        existUser.getUserControl().setOtp(otp);
        userRepo.update(existUser);
        emailService.sendOTP(existUser.getEmail().getValue(), otp);
    }
}
