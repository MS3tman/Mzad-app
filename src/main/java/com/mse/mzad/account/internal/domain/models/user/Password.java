package com.mse.mzad.account.internal.domain.models.user;

import java.util.regex.Pattern;

public class Password {
    private String value;
    private final static Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).{8,}$");

    public Password(String value) {
        if(!PASSWORD_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, and contain at least one lowercase letter, one uppercase letter, one digit, and one special character.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
