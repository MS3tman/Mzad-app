package com.mse.mzad.user.internal.api.controllers;

import com.mse.mzad.user.internal.business.dtos.BaseResponse;
import com.mse.mzad.user.internal.business.dtos.passwordDtos.ForgetPasswordRequest;
import com.mse.mzad.user.internal.business.dtos.loginDtos.LoginRequest;
import com.mse.mzad.user.internal.business.dtos.loginDtos.LoginResponse;
import com.mse.mzad.user.internal.business.dtos.passwordDtos.ResetPasswordRequest;
import com.mse.mzad.user.internal.business.dtos.registerDtos.RegisterRequest;
import com.mse.mzad.user.internal.business.dtos.registerDtos.VerifyEmailRequest;
import com.mse.mzad.user.internal.business.services.LoginService;
import com.mse.mzad.user.internal.business.services.PasswordService;
import com.mse.mzad.user.internal.business.services.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<String, Void>> register(@Valid @RequestBody RegisterRequest registerRequest) throws IOException {
        return registerService.createAccount(registerRequest);
    }

    @PostMapping("/verify")
    public ResponseEntity<BaseResponse<String, Void>> verifyAccount(@Valid @RequestBody VerifyEmailRequest verifyEmail) {
        return registerService.verifyEmail(verifyEmail);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<String, LoginResponse>> login(@Valid @RequestBody LoginRequest login) {
        return loginService.checkUser(login);
    }

    @PostMapping("/forget-password")
    public ResponseEntity<BaseResponse<String, Void>> resetPassword(@Valid @RequestBody ForgetPasswordRequest forgetPasswordRequest) {
        return passwordService.validateEmail(forgetPasswordRequest);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<BaseResponse<String, Void>> resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        return passwordService.changePassword(resetPasswordRequest);
    }

}
