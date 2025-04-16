package com.mse.mzad.user.internal.business.services;

import com.mse.mzad.shared.base.BaseResponse;
import com.mse.mzad.user.internal.business.dtos.registerDtos.RegisterRequest;
import com.mse.mzad.user.internal.business.dtos.registerDtos.VerifyEmailRequest;
import com.mse.mzad.user.internal.business.mappers.RegisterMapper;
import com.mse.mzad.user.internal.business.models.AppUser;
import com.mse.mzad.user.internal.infrastructure.reposatories.IUserRepository;
import com.mse.mzad.user.internal.infrastructure.services.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RegisterService {
    private final IUserRepository userRepository;
    private final EmailService emailService;
    private final RegisterMapper registerMapper;

    public RegisterService(IUserRepository userRepository, EmailService emailService, RegisterMapper registerMapper) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.registerMapper = registerMapper;
    }

    public ResponseEntity<BaseResponse<String, Void>> createAccount(RegisterRequest registerRequest) throws IOException {
        AppUser existUser = userRepository.getByEmail(registerRequest.getEmail());
        if(existUser != null && existUser.isVerified()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new BaseResponse<>(HttpStatus.FORBIDDEN.value(), "User Already Exist", null));
        }
        String otp = emailService.generateOTP();
        AppUser appUser = registerMapper.toEntity(registerRequest, otp);
        userRepository.save(appUser);
        try {
            emailService.sendOTP(registerRequest.getEmail(), otp);
            return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.ACCEPTED.value(), "Check your Emails and send me your otp", null));
        } catch (MessagingException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null));
        }
    }

    public ResponseEntity<BaseResponse<String, Void>> verifyEmail(VerifyEmailRequest verifyEmailRequest) {
        AppUser existUser = userRepository.getByEmail(verifyEmailRequest.getEmail());
        if(existUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Email not found", null));
        }
        if(!existUser.getOtp().equals(verifyEmailRequest.getOtp())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new BaseResponse<>(HttpStatus.FORBIDDEN.value(), "otp is not valid", null));
        }
        existUser.setOtp(null);
        existUser.setVerified(true);
        existUser.setAccountStatus(AppUser.AccountStatus.ALLOW);
        userRepository.save(existUser);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.ACCEPTED.value(), "Email is verified", null));
    }
}
