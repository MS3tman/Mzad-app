package com.mse.mzad.app.internal.domain.models;

public class Country {
    private Long id;
    private String nameAr;
    private String nameEn;
    private String dialCode;
    private int phoneLength;
    private String isoCode;

    public Country(
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
        if(validDialCode(dialCode)){
            this.dialCode = dialCode;
        }
        this.phoneLength = phoneLength;
        this.isoCode = isoCode;
    }

    private boolean validDialCode(String code) {
        String pattern = "^\\+\\d{1,4}$";
        if(!code.matches(pattern)){
            throw new RuntimeException("Invalid dial code: " + code);
        }
        return true;
    }

    public String getDialCode() {
        return dialCode;
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

    public int getPhoneLength() {
        return phoneLength;
    }

    public String getIsoCode() {
        return isoCode;
    }
}
