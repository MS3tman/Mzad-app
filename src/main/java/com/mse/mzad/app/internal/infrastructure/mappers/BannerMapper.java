package com.mse.mzad.app.internal.infrastructure.mappers;

import com.mse.mzad.app.internal.domain.models.Banner;
import com.mse.mzad.app.internal.infrastructure.database.BannerEntity;

public class BannerMapper {

    public static BannerEntity toEntityForCreate(Banner banner) {
        return new BannerEntity(
                banner.getTitle(),
                banner.getImagePath()
        );
    }

    public static BannerEntity toEntityForUpdate(Banner banner) {
        return new BannerEntity(
                banner.getId(),
                banner.getTitle(),
                banner.getImagePath()
        );
    }

    public static Banner toDomain(BannerEntity bannerEntity) {
        return new Banner(
                bannerEntity.getId(),
                bannerEntity.getTitle(),
                bannerEntity.getImagePath()
        );
    }
}
