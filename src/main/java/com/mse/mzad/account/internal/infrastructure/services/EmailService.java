package com.mse.mzad.account.internal.infrastructure.services;

import com.mse.mzad.account.internal.domain.contracts.IEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class EmailService implements IEmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    @Override
    public void sendOTP(String email, String otp) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setSubject("Your OTP Code");
            helper.setText("Your OTP code is: <b>" + otp + "</b>", true);
            mailSender.send(message);
        } catch (MessagingException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
