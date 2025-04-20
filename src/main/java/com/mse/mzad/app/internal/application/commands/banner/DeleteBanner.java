package com.mse.mzad.app.internal.application.commands.banner;

import com.mse.mzad.app.internal.domain.contracts.IAppImageHandler;
import com.mse.mzad.app.internal.domain.contracts.IBannerRepo;
import com.mse.mzad.app.internal.domain.models.Banner;
import org.springframework.stereotype.Service;

@Service
public class DeleteBanner {
    private final IBannerRepo bannerRepo;
    private final IAppImageHandler appImageHandler;

    public DeleteBanner(IBannerRepo bannerRepo, IAppImageHandler appImageHandler) {
        this.bannerRepo = bannerRepo;
        this.appImageHandler = appImageHandler;
    }

    public void delete(long id) {
        Banner existBanner = bannerRepo.findById(id);
        appImageHandler.deleteImage(existBanner.getImagePath());
        bannerRepo.delete(existBanner);
    }
}
