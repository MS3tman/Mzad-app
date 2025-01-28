package com.mse.mzad.signing.infrastructure.services;

public interface IMailProvider {
    public void sender(String to, String subject, String text);
}
