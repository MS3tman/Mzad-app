package com.mse.mzad.signing.business.services;

import com.mse.mzad.signing.business.dtos.ApiResponse;
import com.mse.mzad.signing.business.dtos.HttpStatus;
import com.mse.mzad.signing.business.dtos.LoginData;
import com.mse.mzad.signing.business.dtos.UserData;
import com.mse.mzad.signing.business.models.AppUser;
import com.mse.mzad.signing.business.validators.EmailValidator;
import com.mse.mzad.signing.infrastructure.repositories.IUserRepository;
import com.mse.mzad.signing.infrastructure.services.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private EmailValidator emailValidator;

    public ApiResponse<UserData> login(LoginData loginData) {
        emailValidator.validate(loginData.getEmail());
        Optional<AppUser> appUser = userRepository.findByEmail(loginData.getEmail());
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
        if (!passwordEncoder.matches(loginData.getPassword(), existUser.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        return new ApiResponse<>(HttpStatus.CREATED.getValue(), "Login Successfully", mapToUserData(existUser));
    }

    private UserData mapToUserData(AppUser appUser) {
        UserData userData = new UserData();
        userData.setId(appUser.getId());
        userData.setEmail(appUser.getEmail());
        userData.setFirstName(appUser.getFirstName());
        userData.setLastName(appUser.getLastName());
        userData.setAddress(appUser.getAddress());
        userData.setCountryCode(appUser.getCountryCode());
        userData.setMobile(appUser.getMobile());
        String token = jwtTokenUtils.generateToken(appUser);
        userData.setToken(token);
        return userData;
    }
}
