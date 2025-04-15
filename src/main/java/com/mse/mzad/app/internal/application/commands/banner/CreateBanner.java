package com.mse.mzad.app.internal.application.commands.banner;

import com.mse.mzad.app.internal.domain.contracts.IBannerRepo;
import com.mse.mzad.app.internal.domain.dtos.banner.CreateRequest;
import com.mse.mzad.app.internal.domain.mappers.BannerMapper;
import com.mse.mzad.app.internal.domain.models.banner.Banner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CreateBanner {
    private final IBannerRepo bannerRepo;

    public CreateBanner(IBannerRepo bannerRepo) {
        this.bannerRepo = bannerRepo;
    }

    public Banner create(String title, MultipartFile image) {
        Banner banner = BannerMapper.toDomain(new CreateRequest(title, image));
        return bannerRepo.save(banner);
    }

}
