package com.mse.mzad.app.internal.domain.mappers;

import com.mse.mzad.app.internal.domain.models.Banner;

public class BannerMapper {

    public static Banner toDomain(String imagePath, String title) {
        return new Banner(
            null,
            title,
            imagePath
        );
    }
}
