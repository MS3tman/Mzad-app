package com.mse.mzad.app.internal.domain.mappers;

import com.mse.mzad.app.internal.domain.contracts.IAppImageHandler;
import com.mse.mzad.app.internal.domain.dtos.banner.CreateRequest;
import com.mse.mzad.app.internal.domain.models.banner.Banner;
import org.springframework.beans.factory.annotation.Autowired;

public class BannerMapper {
    @Autowired
    private static IAppImageHandler appImageHandler;

    public static Banner toDomain(CreateRequest request) {
        String imagePath = appImageHandler.saveImage(request.getImage(), "banners");
        return new Banner(
                null, // or any default/auto-generated ID
                request.getTitle(),
                imagePath
        );
    }
}
