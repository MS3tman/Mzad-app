package com.mse.mzad.account.internal.infrastructure.reposatories;

import com.mse.mzad.account.internal.domain.contracts.IUserRepo;
import com.mse.mzad.account.internal.domain.models.user.User;
import com.mse.mzad.account.internal.infrastructure.database.UserEntity;
import com.mse.mzad.account.internal.infrastructure.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements IUserRepo {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper::toDomain)
                .orElse(null);
    }

    @Override
    public User save(User user) {
        UserEntity newUserEntity = UserMapper.toEntityForCreate(user);
        return UserMapper.toDomain(userRepository.save(newUserEntity));
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = UserMapper.toEntityForUpdate(user);
        return UserMapper.toDomain(userRepository.save(userEntity));
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDomain)
                .orElse(null);

    }
}
