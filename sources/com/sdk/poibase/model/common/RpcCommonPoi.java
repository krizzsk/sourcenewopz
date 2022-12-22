package com.sdk.poibase.model.common;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RpcCommonPoi implements Serializable {
    @SerializedName("to_address")
    public String address;
    @SerializedName("addr")
    public String addressDetail;
    @SerializedName("alias_name")
    public String aliasName = "";
    @SerializedName("area")
    public int cityId = 0;
    @SerializedName("cityname")
    public String cityName;
    public String coordinateType;
    @SerializedName("country_code")
    public String countryCode;
    @SerializedName("country_id")
    public int countryID;
    @SerializedName("to_name")
    public String displayName;
    @SerializedName("hide_address")
    public String hide_address;
    @SerializedName("lat")
    public double latitude;
    @SerializedName("lng")
    public double longitude;
    @SerializedName("name")
    public String name;
    public String poi_id;
    public String pre_logo_url;
    @SerializedName("primary_id")
    public String primaryId = "";
    @SerializedName("searchid")
    public String searchId;
    @SerializedName("srctag")
    public String srcTag;
    public int type;
    @SerializedName("uid")
    public String uid;

    public String getDisplayName() {
        return this.displayName;
    }

    public String getAddress() {
        if (!TextUtils.isEmpty(this.address)) {
            return this.address;
        }
        if (!TextUtils.isEmpty(this.addressDetail)) {
            return this.addressDetail;
        }
        return getDisplayName();
    }

    public String toString() {
        return "{cityId=" + this.cityId + ", cityName='" + this.cityName + '\'' + ", type='" + this.type + '\'' + ", name='" + this.name + '\'' + ", displayName='" + this.displayName + '\'' + ", address='" + this.address + '\'' + ", addressDetail='" + this.addressDetail + '\'' + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", uid=" + this.uid + ", searchid=" + this.searchId + ", srctag=" + this.srcTag + ", hide_address=" + this.hide_address + '}';
    }
}
