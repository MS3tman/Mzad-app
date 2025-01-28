package com.mse.mzad.signing.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class Mailtrap implements IMailProvider {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sender(String to, String subject, String text) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to); // Recipient email address
            helper.setSubject(subject); // Email subject
            helper.setText(text, true); // Set the email content as HTML
            helper.setFrom("Mzad-app");
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to access mailtrap service provider", e);
        }
    }
}