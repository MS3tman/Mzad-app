package com.mse.mzad.app.internal.infrastructure.repository;

import com.mse.mzad.app.internal.domain.contracts.IBannerRepo;
import com.mse.mzad.app.internal.domain.models.banner.Banner;
import com.mse.mzad.app.internal.infrastructure.database.BannerEntity;
import com.mse.mzad.app.internal.infrastructure.mappers.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BannerRepository implements IBannerRepo {
    @Autowired
    private IBannerRepository bannerRepository;

    @Override
    public Banner save(Banner banner) {
        BannerEntity bannerEntity = BannerMapper.toEntity(banner);
        return BannerMapper.toDomain(bannerRepository.save(bannerEntity));
    }
}
