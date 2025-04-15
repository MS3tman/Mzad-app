package com.mse.mzad.app.internal.infrastructure.database;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class CountryEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameAr;
    private String nameEn;
    private String dialCode;
    private int phoneLength;
    private String isoCode;

    public CountryEntity() {}

    public CountryEntity(
            String nameAr,
            String nameEn,
            String dialCode,
            int phoneLength,
            String isoCode
    ) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.dialCode = dialCode;
        this.phoneLength = phoneLength;
        this.isoCode = isoCode;
    }

    public CountryEntity(
            Long id,
            String nameAr,
            String nameEn,
            String dialCode,
            int phoneLength,
            String isoCode
    ) {
        this.id = id;
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.dialCode = dialCode;
        this.phoneLength = phoneLength;
        this.isoCode = isoCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public int getPhoneLength() {
        return phoneLength;
    }

    public void setPhoneLength(int phoneLength) {
        this.phoneLength = phoneLength;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
