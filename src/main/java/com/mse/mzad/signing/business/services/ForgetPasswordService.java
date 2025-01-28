package com.mse.mzad.signing.business.services;

import com.mse.mzad.signing.business.dtos.ApiResponse;
import com.mse.mzad.signing.business.dtos.HttpStatus;
import com.mse.mzad.signing.business.models.AppUser;
import com.mse.mzad.signing.business.validators.EmailValidator;
import com.mse.mzad.signing.infrastructure.repositories.IUserRepository;
import com.mse.mzad.signing.infrastructure.services.Mailtrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ForgetPasswordService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private OTPService otpService;
    @Autowired
    private Mailtrap mailtrap;
    @Autowired
    private EmailTemplate emailTemplate;
    @Autowired
    private EmailValidator emailValidator;

    public ApiResponse<String> forgetPassword(String email) {
        System.out.println(email);
        emailValidator.validate(email);
        Optional<AppUser> appUser = userRepository.findByEmail(email);
        if(!appUser.isPresent()){
            throw new IllegalArgumentException("Account Not Exist");
        }
        AppUser existUser = appUser.get();
        if(!existUser.isVerified()) {
            throw new IllegalArgumentException("Account Not Verified");
        }
        if(existUser.getAccountStatus() == AppUser.AccountStatus.DENY) {
            throw new IllegalArgumentException("Account is Blocked");
        }
        String otp = otpService.generateOTP();
        existUser.setOtp(otp);
        userRepository.save(existUser);
        String url = HostService.getCurrentDomain("api/auth/verify/", otp);
        String resetPasswordTemplate = emailTemplate.template(existUser, url, "resetPasswordTemplate.html");
        mailtrap.sender(email, "Reset Password", resetPasswordTemplate);
        return new ApiResponse<>(HttpStatus.CREATED.getValue(), "Check Your Email", email);
    }

}
