package com.mse.mzad.user.internal.infrastructure.services.jwt;

import com.mse.mzad.user.internal.business.models.AppUser;
import com.mse.mzad.user.internal.infrastructure.reposatories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser existUser = userRepository.getByEmail(email);  // Modify this according to your data retrieval logic
        if (existUser == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return User.withUsername(existUser.getEmail())
                .password(existUser.getPassword())
                //.authorities("USER")  // You can set proper roles/authorities here
                .build();
    }
}
