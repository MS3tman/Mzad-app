package com.mse.mzad.account.internal.infrastructure.mappers;

import com.mse.mzad.account.internal.domain.models.user.*;
import com.mse.mzad.account.internal.infrastructure.database.UserEntity;

public class UserMapper {

    public static UserEntity toEntityForCreate(User user) {
        return new UserEntity(
            user.getUserData().getFirstName(),
            user.getUserData().getLastName(),
            user.getUserData().getCountryCode(),
            user.getUserData().getMobile(),
            user.getEmail().getValue(),
            user.getPassword().getValue(),
            user.getUserControl().getOtp(),
            user.getUserData().getUserType()
        );
    }

    public static UserEntity toEntityForUpdate(User user) {
        return new UserEntity(
            user.getUserData().getId(),
            user.getUserData().getFirstName(),
            user.getUserData().getLastName(),
            user.getUserData().getCountryCode(),
            user.getUserData().getMobile(),
            user.getEmail().getValue(),
            user.getPassword().getValue(),
            user.getUserControl().getOtp(),
            user.getUserControl().isVerified(),
            user.getUserData().getUserType(),
            user.getUserImage().getImagePath(),
            user.getUserControl().getUserStatus()
        );
    }

    public static User toDomain(UserEntity userEntity) {
        UserData userData = new UserData(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getCountryCode(),
                userEntity.getMobile(),
                userEntity.getUserType()
        );

        UserControl userControl = new UserControl(
                userEntity.getOtp(),
                userEntity.isVerified(),
                userEntity.getUserStatus()
        );

        return new User(
                userData,
                new Email(userEntity.getEmail()),
                new Password(userEntity.getPassword()),
                userControl,
                new UserImage(userEntity.getImagePath())
        );
    }
}
