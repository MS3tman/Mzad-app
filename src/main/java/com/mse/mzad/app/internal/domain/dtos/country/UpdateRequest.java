package com.mse.mzad.app.internal.domain.dtos.country;

public class UpdateRequest {
    private long id;
    private String nameAr;
    private String nameEn;
    private String dialCode;
    private int phoneLength;
    private String isoCode;

    public UpdateRequest(
            long id,
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

    public String getNameAr() {
        return nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getDialCode() {
        return dialCode;
    }

    public int getPhoneLength() {
        return phoneLength;
    }

    public String getIsoCode() {
        return isoCode;
    }
}
