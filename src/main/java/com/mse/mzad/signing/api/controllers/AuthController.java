package com.mse.mzad.signing.api.controllers;

import com.mse.mzad.signing.business.dtos.*;
import com.mse.mzad.signing.business.models.AppUser;
import com.mse.mzad.signing.business.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private EmailVerification emailVerification;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ForgetPasswordService forgetPasswordService;
    @Autowired
    private ResetPasswordService resetPasswordService;

    @PostMapping("/register")
    public ApiResponse<AppUser> register(@Valid @RequestBody AppUser appUser){
        return registerService.register(appUser);
    }

    @GetMapping("/verify/{otp}")
    public ResponseEntity<String> verifyEmail(@PathVariable("otp") String otp) {
        return emailVerification.verifyEmail(otp);
    }

    @PostMapping("/login")
    public ApiResponse<UserData> login(@RequestBody LoginData loginData) {
        return loginService.login(loginData);
    }

    @PostMapping("/forget-password")
    public ApiResponse<String> forgetPassword(@Valid @RequestBody ForgetPasswordData forgetPasswordData) {
        return forgetPasswordService.forgetPassword(forgetPasswordData.getEmail());
    }

    @PostMapping("/reset-password")
    public ApiResponse<String> resetPassword(@RequestBody ResetPasswordData resetPasswordData) {
       return resetPasswordService.resetPassword(resetPasswordData.getEmail(), resetPasswordData.getPassword());
    }
}
