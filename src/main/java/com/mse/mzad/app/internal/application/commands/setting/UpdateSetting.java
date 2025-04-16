package com.mse.mzad.app.internal.application.commands.setting;

import com.mse.mzad.app.internal.domain.contracts.ISettingRepo;
import com.mse.mzad.app.internal.domain.dtos.setting.UpdateRequest;
import com.mse.mzad.app.internal.domain.mappers.SettingMapper;
import com.mse.mzad.app.internal.domain.models.setting.Setting;
import org.springframework.stereotype.Service;

@Service
public class UpdateSetting {
    private final ISettingRepo settingRepo;

    public UpdateSetting(ISettingRepo settingRepo) {
        this.settingRepo = settingRepo;
    }

    public Setting update(UpdateRequest request) {
        Setting existSetting = settingRepo.findById(request.getId());
        Setting setting = SettingMapper.toDomainForUpdate(request);
        return settingRepo.update(setting);
    }
}
