package com.mse.mzad.app.internal.infrastructure.database;

import jakarta.persistence.*;

@Entity
@Table(name = "banners")
public class BannerEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
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

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImagePath() {
        return imagePath;
    }
}
