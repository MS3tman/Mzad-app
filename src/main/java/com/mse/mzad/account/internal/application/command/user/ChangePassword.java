package com.mse.mzad.account.internal.application.command.user;

import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.dtos.Password.ChangePasswordRequest;
import com.mse.mzad.account.internal.domain.models.user.Password;
import com.mse.mzad.account.internal.domain.models.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ChangePassword {
    private final IUserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public ChangePassword(IUserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void change(ChangePasswordRequest request) {
        User existUser = userRepo.findByEmail(request.getEmail());
        if(existUser == null) {
            throw new RuntimeException("Email Not Exist");
        }
        if(!request.getEmail().equals(existUser.getEmail().getValue()) || !request.getOtp().equals(existUser.getUserControl().getOtp())) {
            throw new RuntimeException("Email or OTP Invalid");
        }
        existUser.getUserControl().setOtp(null);
        new Password(request.getPassword()); // for validate password
        existUser.getPassword().setValue(passwordEncoder.encode(request.getPassword()));
        userRepo.update(existUser);
    }
}
