package com.mse.mzad.app.internal.domain.mappers;

import com.mse.mzad.app.internal.domain.dtos.setting.CreateRequest;
import com.mse.mzad.app.internal.domain.dtos.setting.UpdateRequest;
import com.mse.mzad.app.internal.domain.models.setting.Setting;

public class SettingMapper {

    public static Setting toDomainForCreate(CreateRequest request) {
        return new Setting(
                null,
                request.getKey(),
                request.getValue(),
                request.getType()
        );
    }

    public static Setting toDomainForUpdate(UpdateRequest request) {
        return new Setting(
                request.getId(),
                request.getKey(),
                request.getValue(),
                request.getType()
        );
    }
}
