package com.mse.mzad.app.internal.application.queries.banner;

import com.mse.mzad.app.internal.domain.contracts.IBannerRepo;
import com.mse.mzad.app.internal.domain.models.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadBanner {
    private final IBannerRepo bannerRepo;

    public ReadBanner(IBannerRepo bannerRepo) {
        this.bannerRepo = bannerRepo;
    }

    public List<Banner> all() {
        return bannerRepo.findAll();
    }
}
