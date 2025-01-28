package com.mse.mzad.signing.business.services;

import com.mse.mzad.signing.business.models.AppUser;
import com.mse.mzad.signing.infrastructure.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmailVerification {
    @Autowired
    private IUserRepository userRepository;

    public ResponseEntity<String> verifyEmail(String otp) {
        Optional<AppUser> existUser = userRepository.findByOtp(otp);
        if (!existUser.isPresent()) {
            return ResponseEntity.ok("Account does not exist");
        }
        AppUser user = existUser.get();
        if(user.getOtp().equals(otp)){
            user.setVerified(true);
            user.setAccountStatus(AppUser.AccountStatus.ALLOW);
            user.setOtp("");
            userRepository.save(user);
            return ResponseEntity.ok("Account verified successfully");
        } else {
            return ResponseEntity.ok("Invalid OTP");
        }
    }
}
