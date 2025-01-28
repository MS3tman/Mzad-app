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
public class RegisterService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailTemplate emailTemplate;
    @Autowired
    private OTPService otpService;

    public ApiResponse<AppUser> register(AppUser appUser) {
        emailValidator.validate(appUser.getEmail());
        Optional<AppUser> exisUser = userRepository.findByEmail(appUser.getEmail());
        if(exisUser.isPresent()){
            throw new IllegalArgumentException("Account is Already exist");
        }
        String hashedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(hashedPassword);
        String otp = otpService.generateOTP();
        appUser.setOtp(otp);
        appUser = userRepository.save(appUser);
        String url = HostService.getCurrentDomain("/api/auth/verify/", appUser.getOtp());
        String emailTemplete = emailTemplate.template(appUser, url, "registerTemplate.html");
        otpService.sendToMailtrap(appUser.getEmail(), "Verify Email", emailTemplete);
        return new ApiResponse<>(HttpStatus.CREATED.getValue(), "Account Created Siccessfully", appUser);
    }
}

