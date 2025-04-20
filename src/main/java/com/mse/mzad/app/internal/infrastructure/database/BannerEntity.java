package com.mse.mzad.app.internal.infrastructure.database;

import com.mse.mzad.shared.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Table(name = "banners")
@Getter
public class BannerEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "title is required")
    private String title;
    @NotNull(message = "title is required")
    private String imagePath;

    public BannerEntity(){}

    public BannerEntity(
            String title,
            String imagePath
    ) {
        this.title = title;
        this.imagePath = imagePath;
    }

    public BannerEntity(
            long id,
            String title,
            String imagePath
    ) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
    }
}
