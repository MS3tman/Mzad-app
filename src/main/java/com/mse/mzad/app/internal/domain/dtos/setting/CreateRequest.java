package com.mse.mzad.app.internal.domain.dtos.setting;

import com.mse.mzad.app.internal.domain.models.setting.SettingType;

public class CreateRequest {
    private String key;
    private String value;
    private SettingType type;

    public CreateRequest(String key, String value, SettingType type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public SettingType getType() {
        return type;
    }
}
