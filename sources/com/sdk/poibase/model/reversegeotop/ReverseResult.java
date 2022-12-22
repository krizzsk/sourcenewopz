package com.sdk.poibase.model.reversegeotop;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ReverseResult {
    @SerializedName("aboard_info")
    public AboardInfo aboardInfo;
    @SerializedName("city")
    public String city;
    @SerializedName("city_open")
    public int city_open;
    @SerializedName("cityid")
    public int cityid;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
    @SerializedName("lang")
    public String lang;
    @SerializedName("recom_ripple")
    public int recom_ripple;
    @SerializedName("result")
    public ArrayList<ReverseAddress> result;
    @SerializedName("searchid")
    public String searchid;
    @SerializedName("special_locations")
    public ArrayList<String> special_locations;

    public class ReverseAddress {
        @SerializedName("address")
        public String address;
        @SerializedName("area")
        public String area;
        @SerializedName("cotype")
        public String cotype;
        @SerializedName("displayname")
        public String displayname;
        @SerializedName("gaode_displayname")
        public String gaode_displayname;
        @SerializedName("gaode_lat")
        public String gaode_lat;
        @SerializedName("gaode_lng")
        public String gaode_lng;
        @SerializedName("lat")
        public String lat;
        @SerializedName("lng")
        public String lng;
        @SerializedName("oldaddr")
        public String oldaddr;
        @SerializedName("poi_ui_tag")
        public String poi_ui_tag;
        @SerializedName("srctag")
        public String srctag;
        @SerializedName("uid")
        public String uid;

        public ReverseAddress() {
        }

        public String toString() {
            return "ReverseAddress{displayname='" + this.displayname + '\'' + ", address='" + this.address + '\'' + ", lng='" + this.lng + '\'' + ", lat='" + this.lat + '\'' + ", gaode_displayname='" + this.gaode_displayname + '\'' + ", gaode_lng='" + this.gaode_lng + '\'' + ", gaode_lat='" + this.gaode_lat + '\'' + ", cotype='" + this.cotype + '\'' + ", uid='" + this.uid + '\'' + ", srctag='" + this.srctag + '\'' + ", oldaddr='" + this.oldaddr + '\'' + ", area='" + this.area + '\'' + ", poi_ui_tag='" + this.poi_ui_tag + '\'' + '}';
        }
    }

    public class AboardInfo {
        @SerializedName("confirm_text")
        public String confirmText;
        @SerializedName("description")
        public String description;
        @SerializedName("guidance")
        public String guidance;
        @SerializedName("icon")
        public String icon;
        @SerializedName("title")
        public String title;
        @SerializedName("type")
        public String type;

        public AboardInfo() {
        }

        public String toString() {
            return "AboardInfo{type='" + this.type + '\'' + ", title='" + this.title + '\'' + ", icon='" + this.icon + '\'' + ", description='" + this.description + '\'' + ", guidance='" + this.guidance + '\'' + ", confirmText='" + this.confirmText + '\'' + '}';
        }
    }

    public String toString() {
        return "ReverseGeoResult{errno=" + this.errno + ", cityid=" + this.cityid + ", city='" + this.city + '\'' + ", special_locations=" + this.special_locations + ", recom_ripple=" + this.recom_ripple + ", result=" + this.result + ", city_open=" + this.city_open + ", errmsg='" + this.errmsg + '\'' + ", searchid='" + this.searchid + '\'' + ", lang='" + this.lang + '\'' + ", aboardInfo=" + this.aboardInfo + '}';
    }
}
