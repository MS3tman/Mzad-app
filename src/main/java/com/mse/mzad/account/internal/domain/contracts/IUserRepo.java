package com.mse.mzad.account.internal.domain.contracts;

import com.mse.mzad.account.internal.domain.models.user.User;

public interface IUserRepo {
    User findByEmail(String email);
    User save(User user);
    User update(User user);
    User findById(long id);
}
