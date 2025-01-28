package com.mse.mzad.signing.business.services;

import com.mse.mzad.signing.business.dtos.ApiResponse;
import com.mse.mzad.signing.business.dtos.HttpStatus;
import com.mse.mzad.signing.business.models.AppUser;
import com.mse.mzad.signing.business.validators.EmailValidator;
import com.mse.mzad.signing.infrastructure.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResetPasswordService {
    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ApiResponse<String> resetPassword(String email, String password) {
        emailValidator.validate(email);
        Optional<AppUser> appUser = userRepository.findByEmail(email);
        if(!appUser.isPresent()) {
            throw new IllegalArgumentException("Account is Not Found");
        }
        AppUser existUser = appUser.get();
        if(!existUser.isVerified()){
            throw new IllegalArgumentException("Account is Not Verified");
        }
        if(existUser.getAccountStatus().equals(AppUser.AccountStatus.DENY)) {
            throw new IllegalArgumentException("Account is Blocked");
        }
        existUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(existUser);
        return new ApiResponse<>(HttpStatus.CREATED.getValue(), "Password Change Successfully", null);
    }
}
