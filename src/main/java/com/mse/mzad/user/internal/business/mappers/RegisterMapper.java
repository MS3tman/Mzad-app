package com.mse.mzad.user.internal.business.mappers;

import com.mse.mzad.user.internal.business.dtos.registerDtos.RegisterRequest;
import com.mse.mzad.user.internal.business.models.AppUser;
import com.mse.mzad.user.internal.infrastructure.services.ImageService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class RegisterMapper {
    private final PasswordEncoder passwordEncoder;
    private final ImageService imageService;

    public RegisterMapper(PasswordEncoder passwordEncoder, ImageService imageService) {
        this.passwordEncoder = passwordEncoder;
        this.imageService = imageService;
    }

    public AppUser toEntity(RegisterRequest registerRequest, String otp) throws IOException {
        AppUser newUser = new AppUser();
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());
        newUser.setCountryCode(registerRequest.getCountryCode());
        newUser.setMobile(registerRequest.getMobile());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        if(registerRequest.getImage() != null) {
            try {
                String imagePath = imageService.store(registerRequest.getImage());
                newUser.setImage(imagePath);
            } catch (Exception ex) {
                throw new IOException("Image processing failed: " + ex.getMessage());
            }
        }
        newUser.setUserType(registerRequest.getUserType());
        newUser.setOtp(otp);
        return newUser;
    }
}
