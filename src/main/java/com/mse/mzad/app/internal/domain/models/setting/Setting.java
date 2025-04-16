package com.mse.mzad.app.internal.domain.models.setting;

public class Setting {
    private Long id;
    private String key;
    private String value;
    private SettingType type;

    public Setting(Long id, String key, String value, SettingType type) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public Long getId() {
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
