package com.mse.mzad.user.internal.business.mappers;

import com.mse.mzad.user.internal.business.dtos.registerDtos.RegisterRequest;
import com.mse.mzad.user.internal.business.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser toEntity(RegisterRequest registerRequest, String otp) {
        AppUser newUser = new AppUser();
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());
        newUser.setCountryCode(registerRequest.getCountryCode());
        newUser.setMobile(registerRequest.getMobile());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setImage(registerRequest.getImage());
        newUser.setUserType(registerRequest.getUserType());
        newUser.setOtp(otp);
        return newUser;
    }
}
