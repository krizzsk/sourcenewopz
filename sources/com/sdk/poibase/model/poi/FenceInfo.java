package com.sdk.poibase.model.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class FenceInfo implements Serializable {
    public static final int FENCE_MUSTABSORB = 2;
    public static final int FENCE_NOABSORB = 0;
    public static final int FENCE_WOULDABSORB = 1;
    @SerializedName("area_pickup_desc")
    public String areaPickupDesc;
    @SerializedName("displayname")
    public String displayName;
    @SerializedName("is_draw_fence")
    public int drawFence;
    @SerializedName("extend_info")
    public String extendInfo;
    @SerializedName("fence_bubble_desc")
    public String fenceBubbleDesc;
    @SerializedName("fence_id")
    public String fenceId;
    @SerializedName("fence_name")
    public String fenceName;
    @SerializedName("fence_type")
    public int fenceType;
    @SerializedName("forbidden_reason")
    public String forbiddenReason;
    @SerializedName("infence_absorb_type")
    public int infenceAbsorb;
    @SerializedName("no_parking_lat")
    public double noParkingLat;
    @SerializedName("no_parking_lng")
    public double noParkingLng;
    @SerializedName("polygon")
    public List<FenceLatLng> polygon;
    @SerializedName("recommend_text")
    public String recommendText;
    @SerializedName("station_icon")
    public String stationIcon;
    @SerializedName("welcome_text")
    public String welcomeText;

    public String toString() {
        return "FenceInfo{fenceId='" + this.fenceId + '\'' + ", fenceName='" + this.fenceName + '\'' + ", drawFence=" + this.drawFence + ", infenceAbsorb=" + this.infenceAbsorb + ", fenceBubbleDesc='" + this.fenceBubbleDesc + '\'' + ", polygon=" + this.polygon + ", fenceType=" + this.fenceType + ", displayName='" + this.displayName + '\'' + ", forbiddenReason='" + this.forbiddenReason + '\'' + ", areaPickupDesc='" + this.areaPickupDesc + '\'' + ", extendInfo='" + this.extendInfo + '\'' + ", noParkingLat=" + this.noParkingLat + ", noParkingLng=" + this.noParkingLng + ", welcomeText='" + this.welcomeText + '\'' + ", recommendText='" + this.recommendText + '\'' + ", stationIcon='" + this.stationIcon + '\'' + '}';
    }
}
