package com.mse.mzad.app.internal.application.commands.banner;

import com.mse.mzad.app.internal.domain.contracts.IBannerRepo;
import com.mse.mzad.app.internal.domain.models.banner.Banner;
import com.mse.mzad.app.internal.domain.models.banner.ImageHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class UpdateBanner {
    private final IBannerRepo bannerRepo;

    public UpdateBanner(IBannerRepo bannerRepo) {
        this.bannerRepo = bannerRepo;
    }

    public Banner update(long id, String title, MultipartFile image) {
        Banner existBanner = bannerRepo.findById(id);
        ImageHandler.deleteImage(existBanner.getImagePath());
        String newImagePath = handleImage(image);
        Banner banner = new Banner(id, title, newImagePath);
        return bannerRepo.update(banner);
    }

    public String handleImage(MultipartFile image) {
        try {
            return ImageHandler.saveImage(image);
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

}
