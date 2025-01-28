package com.mse.mzad.signing.business.validators;


import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

@Component
public class EmailValidator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public void validate(String email){
        if(!Pattern.matches(EMAIL_REGEX, email)){
            throw new IllegalArgumentException("Invalid Email format");
        }
    }
}
