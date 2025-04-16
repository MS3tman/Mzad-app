package com.mse.mzad.app.internal.infrastructure.mappers;

import com.mse.mzad.app.internal.domain.models.setting.Setting;
import com.mse.mzad.app.internal.infrastructure.database.SettingEntity;

public class SettingMapper {

    public static SettingEntity toEntityForCreate(Setting setting) {
        return new SettingEntity(
                setting.getKey(),
                setting.getValue(),
                setting.getType()
        );
    }

    public static SettingEntity toEntityForUpdate(Setting setting) {
        return new SettingEntity(
                setting.getId(),
                setting.getKey(),
                setting.getValue(),
                setting.getType()
        );
    }

    public static Setting toDomain(SettingEntity settingEntity) {
        return new Setting(
                settingEntity.getId(),
                settingEntity.getKey(),
                settingEntity.getValue(),
                settingEntity.getType()
        );
    }
}
