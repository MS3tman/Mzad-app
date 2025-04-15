package com.mse.mzad.app.internal.domain.contracts;

import com.mse.mzad.app.internal.domain.models.banner.Banner;

public interface IBannerRepo {
    Banner save(Banner banner);
}
