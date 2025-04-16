package com.mse.mzad.app.internal.application.commands.setting;

import com.mse.mzad.app.internal.domain.contracts.ISettingRepo;
import com.mse.mzad.app.internal.domain.dtos.setting.CreateRequest;
import com.mse.mzad.app.internal.domain.mappers.SettingMapper;
import com.mse.mzad.app.internal.domain.models.setting.Setting;
import org.springframework.stereotype.Service;

@Service
public class CreateSetting {
    private final ISettingRepo settingRepo;

    public CreateSetting(ISettingRepo settingRepo) {
        this.settingRepo = settingRepo;
    }

    public Setting create(CreateRequest request) {
        Setting newSetting = SettingMapper.toDomainForCreate(request);
        return settingRepo.save(newSetting);
    }
}
