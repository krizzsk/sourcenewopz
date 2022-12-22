package com.didi.nova.assembly.country.inner;

public class CountryModel {
    public String callingCode;
    public int countryId;
    public boolean isSelected;
    public String name;
    public String sortKey;

    public CountryModel() {
    }

    public CountryModel(int i, String str, String str2, String str3) {
        this.countryId = i;
        this.name = str;
        this.callingCode = str2;
        this.sortKey = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.countryId == ((CountryModel) obj).countryId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.countryId;
    }
}
