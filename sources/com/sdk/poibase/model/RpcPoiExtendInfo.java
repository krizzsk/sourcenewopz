package com.sdk.poibase.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

public class RpcPoiExtendInfo implements Serializable {
    @SerializedName("address_attribute")
    public ArrayList<AddressAttribute> address_attribute;
    @SerializedName("alias_name")
    public String alias_name;
    @SerializedName("bubble_desc")
    public String bubbleDesc;
    @SerializedName("bubble_desc_new")
    public String bubbleDescV2;
    @SerializedName("business_district")
    public String business_district;
    @SerializedName("business_district_color")
    public String business_district_color;
    @SerializedName("count")
    public int count;
    @SerializedName("displayname_attribute")
    public ArrayList<DisplayNameAttribute> displayName_attribute;
    @SerializedName("distance")
    public String distance;
    @SerializedName("enable_confirm_dropoff")
    public int enable_confirm_dropoff;
    public String eta;
    @SerializedName("guide_back_img")
    public String guide_back_img;
    @SerializedName("has_pickup_point_order")
    public int has_pickup_point_order;
    @SerializedName("in_fade_icon_url")
    public String in_fade_icon_url;
    @SerializedName("in_normal_icon_url")
    public String in_normal_icon_url;
    @SerializedName("is_second_confirm")
    public int isSecondConfirm;
    @SerializedName("is_city_cross")
    public int is_city_cross;
    @SerializedName("main_title_desc")
    public String mainTitleDesc;
    @SerializedName("navigation_text")
    public String navigationText;
    @SerializedName("operation_type")
    public String operation_type;
    @SerializedName("pick_icon_url")
    public String pickIconUrl;
    @SerializedName("picture_style")
    public int pictureStyle;
    @SerializedName("poi_ui_tag")
    public String poi_ui_tag;
    @SerializedName("pre_icon_url")
    public String pre_icon_url;
    @SerializedName("pre_logo_url")
    public String pre_logo_url;
    @SerializedName("primary_id")
    public String primary_id;
    @SerializedName("rawtag")
    public String rawtag;
    @SerializedName("rec_tag")
    public int rec_tag;
    @SerializedName("rec_tag_tittle")
    public String rec_tag_tittle;
    @SerializedName("recpoi_icon_type")
    public int recpoi_icon_type;
    @SerializedName("recpoi_icon_type_desc")
    public String recpoi_icon_type_desc;
    @SerializedName("refer")
    public String refer;
    @SerializedName("start_parking_property")
    public String startParkingProperty;
    @SerializedName("station_bubble_desc")
    public String stationBubbleDesc;
    @SerializedName("station_bubble_desc_new")
    public String stationBubbleDescV2;
    @SerializedName("sub_title_desc")
    public String subTitleDesc;
    @SerializedName("title_tip")
    public String title_tip;
    @SerializedName("walk_guide_photo")
    public String walkGuidePhoto;
    @SerializedName("walk_guide_link")
    public String walk_guide_link;
    @SerializedName("xpanel_desc")
    public String xpanelDesc;

    public static class AddressAttribute implements Serializable {
        @SerializedName("color")
        public String color;
        @SerializedName("length")
        public int length;
        @SerializedName("location")
        public int location;

        public String toString() {
            return "AddressAttribute{location=" + this.location + ", length=" + this.length + ", color='" + this.color + '\'' + '}';
        }
    }

    public static class DisplayNameAttribute implements Serializable {
        @SerializedName("color")
        public String color;
        @SerializedName("length")
        public int length;
        @SerializedName("location")
        public int location;

        public String toString() {
            return "DisplayNameAttribute{location=" + this.location + ", length=" + this.length + ", color='" + this.color + '\'' + '}';
        }
    }

    public String toString() {
        return "RpcPoiExtendInfo{pre_logo_url='" + this.pre_logo_url + '\'' + ", count=" + this.count + ", operation_type='" + this.operation_type + '\'' + ", rawtag='" + this.rawtag + '\'' + ", refer='" + this.refer + '\'' + ", business_district='" + this.business_district + '\'' + ", business_district_color='" + this.business_district_color + '\'' + ", distance='" + this.distance + '\'' + ", pickIconUrl='" + this.pickIconUrl + '\'' + ", navigationText='" + this.navigationText + '\'' + ", eta='" + this.eta + '\'' + ", recpoi_icon_type=" + this.recpoi_icon_type + ", recpoi_icon_type_desc='" + this.recpoi_icon_type_desc + '\'' + ", bubbleDesc='" + this.bubbleDesc + '\'' + ", bubbleDescV2='" + this.bubbleDescV2 + '\'' + ", mainTitleDesc='" + this.mainTitleDesc + '\'' + ", subTitleDesc='" + this.subTitleDesc + '\'' + ", rec_tag='" + this.rec_tag + '\'' + ", rec_tag_tittle='" + this.rec_tag_tittle + '\'' + ", enable_confirm_dropoff='" + this.enable_confirm_dropoff + '\'' + ", title_tip='" + this.title_tip + '\'' + '}';
    }
}
