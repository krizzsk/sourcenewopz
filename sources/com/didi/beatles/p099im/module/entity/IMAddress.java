package com.didi.beatles.p099im.module.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.module.entity.IMAddress */
public class IMAddress implements Serializable {
    private String isoCode;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("area")
    private int mCityId = -1;
    @SerializedName("city")
    private String mCityName;
    @SerializedName("displayname")
    private String mDisplayname;
    @SerializedName("lat")
    private double mLat;
    @SerializedName("lng")
    private double mLng;

    public String getDisplayname() {
        return this.mDisplayname;
    }

    public void setDisplayname(String str) {
        this.mDisplayname = str;
    }

    public String getCityName() {
        return this.mCityName;
    }

    public void setmCityName(String str) {
        this.mCityName = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public double getLat() {
        return this.mLat;
    }

    public void setLat(double d) {
        this.mLat = d;
    }

    public double getLng() {
        return this.mLng;
    }

    public void setLng(double d) {
        this.mLng = d;
    }

    public int getCityId() {
        return this.mCityId;
    }

    public void setCityId(int i) {
        this.mCityId = i;
    }

    public String getIsoCode() {
        return this.isoCode;
    }

    public void setIsoCode(String str) {
        this.isoCode = str;
    }
}
