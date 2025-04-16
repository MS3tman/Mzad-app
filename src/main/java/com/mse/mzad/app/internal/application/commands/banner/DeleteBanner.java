package com.mse.mzad.app.internal.application.commands.banner;

import com.mse.mzad.app.internal.domain.contracts.IBannerRepo;
import com.mse.mzad.app.internal.domain.models.banner.Banner;
import com.mse.mzad.app.internal.domain.models.banner.ImageHandler;
import org.springframework.stereotype.Service;

@Service
public class DeleteBanner {
    private final IBannerRepo bannerRepo;

    public DeleteBanner(IBannerRepo bannerRepo) {
        this.bannerRepo = bannerRepo;
    }

    public void delete(long id) {
        Banner existBanner = bannerRepo.findById(id);
        ImageHandler.deleteImage(existBanner.getImagePath());
        bannerRepo.delete(existBanner);
    }
}
