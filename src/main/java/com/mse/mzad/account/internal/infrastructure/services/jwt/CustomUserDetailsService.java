package com.mse.mzad.account.internal.infrastructure.services.jwt;

import com.mse.mzad.account.internal.infrastructure.database.UserEntity;
import com.mse.mzad.account.internal.infrastructure.reposatories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> exitUserEntity = userRepository.findByEmail(email);  // Modify this according to your data retrieval logic
        if (exitUserEntity.get() == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return User.withUsername(exitUserEntity.get().getEmail())
                .password(exitUserEntity.get().getPassword())
                //.authorities("USER")  // You can set proper roles/authorities here
                .build();
    }
}
