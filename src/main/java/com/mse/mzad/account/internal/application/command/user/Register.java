package com.mse.mzad.account.internal.application.command.user;

import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.dtos.Register.RegisterRequest;
import com.mse.mzad.account.internal.domain.mappers.RegisterMapper;
import com.mse.mzad.account.internal.domain.models.user.User;
import com.mse.mzad.account.internal.infrastructure.services.EmailService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Register {
    private final IUserRepo userRepo;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    public Register(IUserRepo userRepo, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    public void createAccount(RegisterRequest request) {
        User existUser = userRepo.findByEmail(request.getEmail());
        if (existUser != null) {
            if (existUser.getUserControl().isVerified()) {
                throw new RuntimeException("Email already exists.");
            } else {
                throw new RuntimeException("Your email is not yet verified, go verify your email.");
            }
        }
        String otp = emailService.generateOTP();
        User newUser = RegisterMapper.toDomainForRegister(request, otp); // plaintext password for verify
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser = RegisterMapper.toDomainForRegister(request, otp); // encoded password for store in DB
        userRepo.save(newUser);
        emailService.sendOTP(newUser.getEmail().getValue(), otp);
    }
}
