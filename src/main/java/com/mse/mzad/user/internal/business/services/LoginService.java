package com.mse.mzad.user.internal.business.services;

import com.mse.mzad.user.internal.business.dtos.BaseResponse;
import com.mse.mzad.user.internal.business.dtos.loginDtos.LoginRequest;
import com.mse.mzad.user.internal.business.dtos.loginDtos.LoginResponse;
import com.mse.mzad.user.internal.business.mappers.LoginMapper;
import com.mse.mzad.user.internal.business.models.AppUser;
import com.mse.mzad.user.internal.business.services.jwt.JwtService;
import com.mse.mzad.user.internal.infrastructure.reposatories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginMapper loginMapper;

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
