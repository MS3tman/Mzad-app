package com.mse.mzad.app.internal.infrastructure.repository;

import com.mse.mzad.app.internal.domain.contracts.IBannerRepo;
import com.mse.mzad.app.internal.domain.models.Banner;
import com.mse.mzad.app.internal.infrastructure.database.BannerEntity;
import com.mse.mzad.app.internal.infrastructure.mappers.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BannerRepository implements IBannerRepo {
    @Autowired
    private IBannerRepository bannerRepository;

    @Override
    public Banner save(Banner banner) {
        BannerEntity bannerEntity = BannerMapper.toEntityForCreate(banner);
        return BannerMapper.toDomain(bannerRepository.save(bannerEntity));
    }

    @Override
    public Banner findById(long id) {
        Optional<BannerEntity> existBannerEntity = bannerRepository.findById(id);
        if(existBannerEntity.isEmpty()) {
            throw new RuntimeException("Banner not found");
        }
        return BannerMapper.toDomain(existBannerEntity.get());
    }

    @Override
    public Banner update(Banner banner) {
        BannerEntity bannerEntity = BannerMapper.toEntityForUpdate(banner);
        return BannerMapper.toDomain(bannerRepository.save(bannerEntity));
    }

    @Override
    public void delete(Banner banner) {
        BannerEntity existBannerEntity = BannerMapper.toEntityForUpdate(banner);
        bannerRepository.delete(existBannerEntity);
    }

    @Override
    public List<Banner> findAll() {
        List<BannerEntity> bannerEntityList = bannerRepository.findAll();
        if(bannerEntityList.isEmpty()) {
            throw new RuntimeException("Not found banners");
        }
        List<Banner> bannerList = new ArrayList<>();
        for(BannerEntity banner : bannerEntityList) {
            bannerList.add(BannerMapper.toDomain(banner));
        }
        return bannerList;
    }
}
