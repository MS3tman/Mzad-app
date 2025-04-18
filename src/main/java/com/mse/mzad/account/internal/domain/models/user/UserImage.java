package com.mse.mzad.account.internal.domain.models.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserImage {
    private String imagePath;

    public UserImage(String imagePath) {
        this.imagePath = imagePath;
    }


}
