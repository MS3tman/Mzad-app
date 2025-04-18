package com.mse.mzad.account.internal.application.query.user;

import com.mse.mzad.account.internal.domain.contracts.IJwtService;
import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.dtos.Login.LoginRequest;
import com.mse.mzad.account.internal.domain.dtos.Login.LoginResponse;
import com.mse.mzad.account.internal.domain.mappers.LoginMapper;
import com.mse.mzad.account.internal.domain.models.user.User;
import com.mse.mzad.account.internal.domain.models.user.UserStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Login {
    private final IUserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;

    public Login(IUserRepo userRepo, PasswordEncoder passwordEncoder, IJwtService jwtService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse checkCredentials(LoginRequest request) {
        User existUser = userRepo.findByEmail(request.getEmail());
        if(existUser == null) {
            throw new RuntimeException("Email Not Found");
        }
        if(!existUser.getUserControl().isVerified()) {
            throw new RuntimeException("Account not Verified, go to verified your Account");
        }
        if(existUser.getUserControl().getUserStatus() == UserStatus.DENY) {
            throw new RuntimeException("Account Deny");
        }
        if(!request.getEmail().equals(existUser.getEmail().getValue()) || !passwordEncoder.matches(request.getPassword(), existUser.getPassword().getValue())) {
            throw new RuntimeException("Credentials Not Valid");
        }
        String token = jwtService.generateToken(existUser.getEmail().getValue());
        return LoginMapper.toLoginResponse(existUser, token);
    }
}
