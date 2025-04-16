package com.mse.mzad.app.internal.application.commands.setting;

import com.mse.mzad.app.internal.domain.contracts.ISettingRepo;
import com.mse.mzad.app.internal.domain.models.setting.Setting;
import org.springframework.stereotype.Service;

@Service
public class DeleteSetting {
    private final ISettingRepo settingRepo;

    public DeleteSetting(ISettingRepo settingRepo) {
        this.settingRepo = settingRepo;
    }

    public void delete(long id) {
        Setting existSetting = settingRepo.findById(id);
        settingRepo.delete(existSetting);
    }
}
