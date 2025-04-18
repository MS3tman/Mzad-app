package com.mse.mzad.account.internal.domain.contracts;

public interface IJwtService {
    String generateToken(String email);
}
