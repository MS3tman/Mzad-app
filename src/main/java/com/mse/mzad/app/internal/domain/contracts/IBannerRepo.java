package com.mse.mzad.app.internal.domain.contracts;

import com.mse.mzad.app.internal.domain.models.banner.Banner;
import java.util.List;

public interface IBannerRepo {
    Banner save(Banner banner);
    Banner findById(long id);
    Banner update(Banner banner);
    void delete(Banner banner);
    List<Banner> findAll();
}
