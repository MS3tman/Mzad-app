package com.mse.mzad.user.internal.business.mappers;

import com.mse.mzad.user.internal.business.dtos.loginDtos.LoginRequest;
import com.mse.mzad.user.internal.business.dtos.loginDtos.LoginResponse;
import com.mse.mzad.user.internal.business.models.AppUser;
import com.mse.mzad.user.internal.infrastructure.reposatories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {
    @Autowired
    private IUserRepository userRepository;

    public LoginResponse toDto(LoginRequest loginRequest, String token) {
        AppUser existUser = userRepository.getByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(existUser.getId());
        loginResponse.setFirstName(existUser.getFirstName());
        loginResponse.setLastName(existUser.getLastName());
        loginResponse.setCountryCode(existUser.getCountryCode());
        loginResponse.setMobile(existUser.getMobile());
        loginResponse.setEmail(existUser.getEmail());
        loginResponse.setUserType(existUser.getUserType().name());
        loginResponse.setImage(existUser.getImage());
        loginResponse.setToken(token);
        return loginResponse;
    }
}
