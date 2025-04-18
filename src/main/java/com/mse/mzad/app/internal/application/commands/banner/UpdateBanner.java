package com.mse.mzad.app.internal.application.commands.banner;

import com.mse.mzad.app.internal.domain.contracts.IAppImageHandler;
import com.mse.mzad.app.internal.domain.contracts.IBannerRepo;
import com.mse.mzad.app.internal.domain.models.banner.Banner;
import com.mse.mzad.shared.services.ImageHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class UpdateBanner {
    private final IBannerRepo bannerRepo;
    private final IAppImageHandler appImageHandler;

    public UpdateBanner(IBannerRepo bannerRepo, IAppImageHandler appImageHandler) {
        this.bannerRepo = bannerRepo;
        this.appImageHandler = appImageHandler;
    }

    public Banner update(long id, String title, MultipartFile image) {
        Banner existBanner = bannerRepo.findById(id);
        appImageHandler.deleteImage(existBanner.getImagePath());
        String newImagePath = appImageHandler.saveImage(image, "banners");
        Banner banner = new Banner(id, title, newImagePath);
        return bannerRepo.update(banner);
    }

}
