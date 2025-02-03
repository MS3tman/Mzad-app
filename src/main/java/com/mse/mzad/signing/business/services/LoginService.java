package com.mse.mzad.signing.business.services;

import com.mse.mzad.signing.business.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import com.mse.mzad.signing.business.dtos.LoginRequest;
import com.mse.mzad.signing.business.dtos.LoginResponse;
import com.mse.mzad.signing.business.models.AppUser;
import com.mse.mzad.signing.business.services.jwt.JwtUtils;
import com.mse.mzad.signing.business.validators.EmailValidator;
import com.mse.mzad.signing.infrastructure.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    public ApiResponse<LoginResponse> login(LoginRequest loginRequest) {
        emailValidator.validate(loginRequest.getEmail());
        Optional<AppUser> appUser = userRepository.findByEmail(loginRequest.getEmail());
        if(!appUser.isPresent()) {
            throw new IllegalArgumentException("Account not exist");
        }
        AppUser existUser = appUser.get();
        if(!existUser.isVerified()) {
            throw new IllegalArgumentException("Account not Verified");
        }
        if(!existUser.getAccountStatus().equals(AppUser.AccountStatus.ALLOW)) {
            throw new IllegalArgumentException("Account is Blocked");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), existUser.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);
        return new ApiResponse<>(HttpStatus.CREATED.value(), "Login Successfully", mapToLoginResponse(existUser, jwtToken));
    }

    private LoginResponse mapToLoginResponse(AppUser appUser, String jwtToken) {
        LoginResponse userData = new LoginResponse();
        userData.setId(appUser.getId());
        userData.setEmail(appUser.getEmail());
        userData.setFirstName(appUser.getFirstName());
        userData.setLastName(appUser.getLastName());
        userData.setAddress(appUser.getAddress());
        userData.setCountryCode(appUser.getCountryCode());
        userData.setMobile(appUser.getMobile());
        userData.setToken(jwtToken);
        return userData;
    }
}
