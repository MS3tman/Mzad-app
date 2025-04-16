package com.mse.mzad.app.internal.infrastructure.repository;

import com.mse.mzad.app.internal.domain.contracts.ISettingRepo;
import com.mse.mzad.app.internal.domain.models.setting.Setting;
import com.mse.mzad.app.internal.infrastructure.database.SettingEntity;
import com.mse.mzad.app.internal.infrastructure.mappers.SettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SettingRepository implements ISettingRepo {
    @Autowired
    private ISettingRepository settingRepository;

    @Override
    public Setting save(Setting setting) {
        SettingEntity settingEntity = SettingMapper.toEntityForCreate(setting);
        return SettingMapper.toDomain(settingRepository.save(settingEntity));
    }

    @Override
    public Setting findById(long id) {
        Optional<SettingEntity> settingEntity = settingRepository.findById(id);
        if (settingEntity.isEmpty()) {
            throw new RuntimeException("Setting Not Found");
        }
        return SettingMapper.toDomain(settingEntity.get());
    }

    @Override
    public Setting update(Setting setting) {
        SettingEntity settingEntity = SettingMapper.toEntityForUpdate(setting);
        return SettingMapper.toDomain(settingRepository.save(settingEntity));
    }

    @Override
    public void delete(Setting setting) {
        SettingEntity settingEntity = SettingMapper.toEntityForUpdate(setting);
        settingRepository.delete(settingEntity);
    }

    @Override
    public List<Setting> findAll() {
        List<SettingEntity> settingEntityList = settingRepository.findAll();
        if(settingEntityList.isEmpty()) {
            throw new RuntimeException("Not Found Setting");
        }
        List<Setting> settingList = new ArrayList<>();
        for(SettingEntity settingEntity : settingEntityList) {
            settingList.add(SettingMapper.toDomain(settingEntity));
        }
        return settingList;
    }
}
