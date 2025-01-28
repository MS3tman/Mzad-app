package com.mse.mzad.signing.business.services;

import com.mse.mzad.signing.infrastructure.services.IMailProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class OTPService {
    @Autowired
    private IMailProvider mailProvider;

    public void sendToMailtrap(String to, String subject, String text) {
        mailProvider.sender(to, subject, text);
    }

    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generates a 6-digit number
        return String.valueOf(otp);
    }
}
