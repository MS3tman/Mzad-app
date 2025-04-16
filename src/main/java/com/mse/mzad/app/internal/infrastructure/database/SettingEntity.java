package com.mse.mzad.app.internal.infrastructure.database;

import com.mse.mzad.app.internal.domain.models.setting.SettingType;
import jakarta.persistence.*;

@Entity
@Table(name = "settings")
public class SettingEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "`key`")
    private String key;
    private String value;
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
