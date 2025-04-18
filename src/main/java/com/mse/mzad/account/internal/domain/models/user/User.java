package com.mse.mzad.account.internal.domain.models.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private final UserData userData;
    private final Email email;
    private final Password password;
    private final UserControl userControl;
    private final UserImage userImage;

    public User(
            UserData user,
            Email email,
            Password password,
            UserControl userControl,
            UserImage userImage
    ) {
        this.userData = user;
        this.email = email;
        this.password = password;
        this.userControl = userControl;
        this.userImage = userImage;
    }
}
