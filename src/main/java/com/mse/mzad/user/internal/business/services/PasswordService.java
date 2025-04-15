package com.mse.mzad.user.internal.business.services;

import com.mse.mzad.user.internal.business.dtos.BaseResponse;
import com.mse.mzad.user.internal.business.dtos.passwordDtos.ForgetPasswordRequest;
import com.mse.mzad.user.internal.business.dtos.passwordDtos.ResetPasswordRequest;
import com.mse.mzad.user.internal.business.models.AppUser;
import com.mse.mzad.user.internal.infrastructure.reposatories.IUserRepository;
import com.mse.mzad.user.internal.infrastructure.services.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    private final IUserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    public PasswordService(IUserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<BaseResponse<String, Void>> validateEmail(ForgetPasswordRequest forgetPasswordRequest) {
        AppUser existUser = userRepository.getByEmail(forgetPasswordRequest.getEmail());
        if(existUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "User Not Exist", null));
        }
        String otp = emailService.generateOTP();
        existUser.setOtp(otp);
        userRepository.save(existUser);
        try {
            emailService.sendOTP(forgetPasswordRequest.getEmail(), otp);
            return ResponseEntity.ok(new BaseResponse<>(HttpStatus.ACCEPTED.value(), "Check your Email", null));
        } catch (MessagingException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null));
        }
    }

    public ResponseEntity<BaseResponse<String, Void>> changePassword(ResetPasswordRequest resetPasswordRequest) {
        AppUser existUser = userRepository.getByEmail(resetPasswordRequest.getEmail());
        if(existUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "User Not Exist", null));
        }
        if(existUser.getOtp() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "Do forget password first", null));
        }
        if(!existUser.getOtp().equals(resetPasswordRequest.getOtp())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Otp is Incorrect", null));
        }
        existUser.setPassword(passwordEncoder.encode(resetPasswordRequest.getPassword()));
        existUser.setOtp(null);
        userRepository.save(existUser);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.CREATED.value(), "Password is changed", null));
    }

}
