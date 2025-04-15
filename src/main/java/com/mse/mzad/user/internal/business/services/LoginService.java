package com.mse.mzad.user.internal.business.services;

import com.mse.mzad.user.internal.business.dtos.BaseResponse;
import com.mse.mzad.user.internal.business.dtos.loginDtos.LoginRequest;
import com.mse.mzad.user.internal.business.dtos.loginDtos.LoginResponse;
import com.mse.mzad.user.internal.business.mappers.LoginMapper;
import com.mse.mzad.user.internal.business.models.AppUser;
import com.mse.mzad.user.internal.infrastructure.services.jwt.JwtService;
import com.mse.mzad.user.internal.infrastructure.reposatories.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final LoginMapper loginMapper;

    public LoginService(IUserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, LoginMapper loginMapper) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.loginMapper = loginMapper;
    }

    public ResponseEntity<BaseResponse<String, LoginResponse>> checkUser(LoginRequest login) {
        AppUser existUser = userRepository.getByEmail(login.getEmail());
        if(existUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), "User not found", null));
        }
        if(!passwordEncoder.matches(login.getPassword(), existUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new BaseResponse<>(HttpStatus.FORBIDDEN.value(), "Incorrect Password", null));
        }
        if(!existUser.isVerified()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new BaseResponse<>(HttpStatus.FORBIDDEN.value(), "Email not verified", null));
        }
        String token = jwtService.generateToken(existUser.getEmail());
        LoginResponse loginResponse = loginMapper.toDto(login, token);
        return ResponseEntity.ok(new BaseResponse<>(HttpStatus.OK.value(), "Login Successfully", loginResponse));
    }
}
