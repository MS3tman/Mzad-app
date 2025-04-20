package com.mse.mzad.app.internal.application.commands.banner;

import com.mse.mzad.app.internal.domain.contracts.IAppImageHandler;
import com.mse.mzad.app.internal.domain.contracts.IBannerRepo;
import com.mse.mzad.app.internal.domain.mappers.BannerMapper;
import com.mse.mzad.app.internal.domain.models.Banner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CreateBanner {
    private final IBannerRepo bannerRepo;
    private final IAppImageHandler appImageHandler;

    public CreateBanner(IBannerRepo bannerRepo, IAppImageHandler appImageHandler) {
        this.bannerRepo = bannerRepo;
        this.appImageHandler = appImageHandler;
    }

    public Banner create(String title, MultipartFile image) {
        System.out.println(title);
        String imagePath = appImageHandler.saveImage(image, "banners");
        Banner banner = BannerMapper.toDomain(imagePath, title);
        return bannerRepo.save(banner);
    }

}
