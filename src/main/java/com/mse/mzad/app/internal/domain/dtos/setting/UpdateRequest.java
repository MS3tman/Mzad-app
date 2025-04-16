package com.mse.mzad.app.internal.domain.dtos.setting;

import com.mse.mzad.app.internal.domain.models.setting.SettingType;

public class UpdateRequest {
    private long id;
    private String key;
    private String value;
    private SettingType type;

    public UpdateRequest(long id, String key, String value, SettingType type) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public long getId() {
        return id;
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
