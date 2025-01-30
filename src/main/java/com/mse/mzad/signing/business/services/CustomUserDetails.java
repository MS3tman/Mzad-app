package com.mse.mzad.signing.business.services;

import com.mse.mzad.signing.business.models.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;


public class CustomUserDetails implements UserDetails {
    private final AppUser appUser;

    public CustomUserDetails(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return appUser.getAuthorities(); // Assuming AppUser has a method to get authorities/roles
    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getEmail(); // Assuming email is used as the username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Customize based on your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Customize based on your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Customize based on your requirements
    }

    @Override
    public boolean isEnabled() {
        return true; // Customize based on your requirements
    }
}
