package com.mse.mzad.account.internal.domain.contracts;

public interface IEmailService {
    String generateOTP();
    void sendOTP(String email, String otp);
}
