package com.didi.sdk.net;

import com.didi.sdk.util.LocaleUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HeaderContent implements Serializable {
    private static final long serialVersionUID = 1;
    @SerializedName("TripCountry")
    private String TripCountry;
    @SerializedName("app_timeout_ms")
    private long appTimeout;
    @SerializedName("Cityid")
    private String cityId;
    @SerializedName("currency")
    private String currency;
    @SerializedName("lang")
    private String lang;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lng")
    private double lng;
    @SerializedName("locale")
    private String localeCode;
    @SerializedName("location_cityid")
    private String location_cityid;
    @SerializedName("location_country")
    private String location_country;
    @SerializedName("product_id")
    private String productId;
    @SerializedName("trip_cityid")
    private String tripCity;
    @SerializedName("trip_country")
    private String trip_country;
    @SerializedName("utc_offset")
    private int utc_offset;

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public long getAppTimeout() {
        return this.appTimeout;
    }

    public void setAppTimeout(long j) {
        this.appTimeout = j;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCityId(String str) {
        this.cityId = str;
    }

    public void setUtc_offset(int i) {
        this.utc_offset = i;
    }

    public void setTripCountry(String str) {
        this.TripCountry = str;
    }

    public void setLocation_country(String str) {
        this.location_country = str;
    }

    public void setLocation_cityid(String str) {
        this.location_cityid = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setTrip_country(String str) {
        this.trip_country = str;
    }

    public String getLocaleCode() {
        return this.localeCode;
    }

    public void setLocaleCode(String str) {
        this.localeCode = LocaleUtils.convertLang2Locale(str);
    }

    public void setTripCity(String str) {
        this.tripCity = str;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double d) {
        this.lat = d;
    }
}
