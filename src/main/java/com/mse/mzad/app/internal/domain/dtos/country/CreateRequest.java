package com.mse.mzad.app.internal.domain.dtos.country;

public class CreateRequest {
    private String nameAr;
    private String nameEn;
    private String dialCode;
    private int phoneLength;
    private String isoCode;

    public CreateRequest(
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
