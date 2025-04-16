package com.mse.mzad.app.internal.application.queries.setting;

import com.mse.mzad.app.internal.domain.contracts.ISettingRepo;
import com.mse.mzad.app.internal.domain.models.setting.Setting;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReadSetting {
    private final ISettingRepo settingRepo;

    public ReadSetting(ISettingRepo settingRepo) {
        this.settingRepo = settingRepo;
    }

    public List<Setting> all() {
        return settingRepo.findAll();
    }

}
