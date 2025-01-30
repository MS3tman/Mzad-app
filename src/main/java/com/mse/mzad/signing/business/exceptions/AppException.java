package com.mse.mzad.signing.business.exceptions;

public class AppException extends RuntimeException{

    public static class EmailAlreadyExistsException extends RuntimeException {
        public EmailAlreadyExistsException(String message) {
            super(message);
        }
    }

}
