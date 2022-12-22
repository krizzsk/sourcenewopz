package com.sdk.poibase.model;

import com.didi.sdk.apm.SystemUtils;
import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.city.RpcCity;
import java.io.Serializable;
import java.util.ArrayList;

public class RpcPoiBaseInfo implements Serializable, Cloneable {
    public static final String COORDINATE_TYPE_BD09 = "bd09";
    public static final String COORDINATE_TYPE_GCJ02 = "gcj02";
    public static final String COORDINATE_TYPE_WGS84 = "wgs84";
    public static final String MAP_TYPE_APPLE = "imap";
    public static final String MAP_TYPE_BAIDU = "bmap";
    public static final String MAP_TYPE_DIDI = "dmap";
    public static final String MAP_TYPE_GAODE = "amap";
    public static final String MAP_TYPE_GOOGLE = "gmap";
    public static final String MAP_TYPE_TENCENT = "tmap";
    @SerializedName("address")
    public String address;
    @SerializedName("addressAll")
    public String addressAll;
    @SerializedName("city_id")
    public int city_id;
    @SerializedName("city_name")
    public String city_name;
    @SerializedName("coordinate_type")
    public String coordinate_type;
    @SerializedName("country_code")
    public String countryCode;
    @SerializedName("country_id")
    public int countryId;
    @SerializedName("displayname")
    public String displayname;
    @SerializedName("fullname")
    public String fullname;
    @SerializedName("hide_address")
    public String hide_address;
    public int isAirPortPickUpPoint;
    @SerializedName("is_nearest")
    public int is_nearest;
    @SerializedName("is_recommend_absorb")
    public int is_recommend_absorb;
    @SerializedName("lat")
    public double lat;
    @SerializedName("lng")
    public double lng;
    public long localPickUpPointId = -1;
    @SerializedName("poi_id")
    public String poi_id;
    @SerializedName("poi_source")
    public String poi_source;
    @SerializedName("poi_tag")
    public ArrayList<RpcPoiBaseInfoTag> poi_tag;
    public String searchId;
    @SerializedName("srctag")
    public String srctag;
    @SerializedName("weight")
    public double weight;

    public String toString() {
        return "RpcPoiBaseInfo{poi_id='" + this.poi_id + '\'' + ", poi_source='" + this.poi_source + '\'' + ", displayname='" + this.displayname + '\'' + ", fullname='" + this.fullname + '\'' + ", address='" + this.address + '\'' + ", addressAll='" + this.addressAll + '\'' + ", lat=" + this.lat + ", lng=" + this.lng + ", srctag='" + this.srctag + '\'' + ", is_recommend_absorb=" + this.is_recommend_absorb + ", coordinate_type='" + this.coordinate_type + '\'' + ", weight=" + this.weight + ", city_id=" + this.city_id + ", poi_tag=" + this.poi_tag + ", city_name='" + this.city_name + '\'' + ", searchId='" + this.searchId + '\'' + ", isAirPortPickUpPoint=" + this.isAirPortPickUpPoint + ", localPickUpPointId=" + this.localPickUpPointId + ", hide_address=" + this.hide_address + ", countryId=" + this.countryId + ", countryCode='" + this.countryCode + '\'' + ", is_nearest='" + this.is_nearest + '\'' + '}';
    }

    public RpcCity getCity() {
        RpcCity rpcCity = new RpcCity();
        rpcCity.cityId = this.city_id;
        rpcCity.name = this.city_name;
        return rpcCity;
    }

    public RpcPoiBaseInfo clone() {
        try {
            return (RpcPoiBaseInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            SystemUtils.log(6, "yangxj", "clone(RpcPoiBaseInfo.java:72) :", (Throwable) null, "com.sdk.poibase.model.RpcPoiBaseInfo", 141);
            return null;
        }
    }

    public boolean isSameCity(RpcPoiBaseInfo rpcPoiBaseInfo) {
        return rpcPoiBaseInfo != null && this.city_id == rpcPoiBaseInfo.city_id;
    }
}
