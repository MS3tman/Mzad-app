package com.mse.mzad.app.internal.infrastructure.database;

import com.mse.mzad.app.internal.domain.models.setting.SettingType;
import com.mse.mzad.shared.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "settings")
public class SettingEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "key is required")
    @Column(name = "`key`")
    private String key;
    @NotNull(message = "value is required")
    private String value;
    @NotNull(message = "type is required")
    @Enumerated(EnumType.STRING)
    private SettingType type;

    public SettingEntity() {}

    public SettingEntity(
            String key,
            String value,
            SettingType type
    ) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public SettingEntity(
            Long id,
            String key,
            String value,
            SettingType type
    ) {
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
