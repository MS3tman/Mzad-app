package com.mse.mzad.account.internal.api.controllers;

import com.mse.mzad.account.internal.application.command.user.ChangePassword;
import com.mse.mzad.account.internal.application.command.user.Register;
import com.mse.mzad.account.internal.application.command.user.VerifyEmailForRegister;
import com.mse.mzad.account.internal.application.query.user.Login;
import com.mse.mzad.account.internal.application.query.user.ResetPassword;
import com.mse.mzad.account.internal.domain.dtos.user.Login.LoginRequest;
import com.mse.mzad.account.internal.domain.dtos.user.Login.LoginResponse;
import com.mse.mzad.account.internal.domain.dtos.user.Password.ChangePasswordRequest;
import com.mse.mzad.account.internal.domain.dtos.user.Password.ResetPasswordRequest;
import com.mse.mzad.account.internal.domain.dtos.user.Register.RegisterRequest;
import com.mse.mzad.account.internal.domain.dtos.user.Register.VerifyEmailRequest;
import com.mse.mzad.account.internal.domain.models.user.UserData;
import com.mse.mzad.shared.base.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private Register register;
    @Autowired
    private VerifyEmailForRegister verifyEmailForRegister;
    @Autowired
    private Login login;
    @Autowired
    private ResetPassword resetPassword;
    @Autowired
    private ChangePassword changePassword;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<String, UserData>> register(@Valid @RequestBody RegisterRequest request) {
        register.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(new BaseResponse<>(HttpStatus.CREATED.value(), "User Created Successfully, Check your Emails", null));
    }

    @PostMapping("/verify")
    public ResponseEntity<BaseResponse<String, Void>> verifyAccount(@Valid @RequestBody VerifyEmailRequest verifyEmailRequest) {
        verifyEmailForRegister.verifyEmail(verifyEmailRequest);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Email is verified", null));
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<String, LoginResponse>> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Login Successfully", login.checkCredentials(request)));
    }

    @PostMapping("/password/reset")
    public ResponseEntity<BaseResponse<String, Void>> resetPassword(@RequestBody ResetPasswordRequest request) {
        resetPassword.verifyEmail(request);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Check you email", null));
    }

    @PostMapping("/password/change")
    public ResponseEntity<BaseResponse<String, Void>> resetPassword(@Valid @RequestBody ChangePasswordRequest request) {
        changePassword.change(request);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Password is changed", null));
    }

}
