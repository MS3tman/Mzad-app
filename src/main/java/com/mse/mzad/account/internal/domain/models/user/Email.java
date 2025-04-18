package com.mse.mzad.account.internal.domain.models.user;

import java.util.regex.Pattern;

public class Email {
    private final String value;
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public Email(String value) {
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
