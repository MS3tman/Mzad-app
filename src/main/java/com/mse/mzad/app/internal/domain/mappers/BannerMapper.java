package com.mse.mzad.app.internal.domain.mappers;

import com.mse.mzad.app.internal.domain.dtos.banner.CreateRequest;
import com.mse.mzad.app.internal.domain.models.banner.Banner;
import com.mse.mzad.app.internal.domain.models.banner.ImageHandler;
import java.io.IOException;

public class BannerMapper {

    public static Banner toDomain(CreateRequest request) {
        String imagePath;
        try {
            imagePath = ImageHandler.saveImage(request.getImage());
        } catch (IOException ex) {
            throw new RuntimeException("Failed to save image: " + ex.getMessage());
        }

        return new Banner(
                null, // or any default/auto-generated ID
                request.getTitle(),
                imagePath
        );
    }
}
