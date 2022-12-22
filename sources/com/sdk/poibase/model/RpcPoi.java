package com.sdk.poibase.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class RpcPoi implements Serializable {
    @SerializedName("base_info")
    public RpcPoiBaseInfo base_info;
    public long curTimeMills;
    @SerializedName("discount_poi")
    public ArrayList<RpcPoi> discount_poi;
    @SerializedName("extend_info")
    public RpcPoiExtendInfo extend_info;
    public String[] geofence;
    public boolean isDiscountPoi;
    public boolean isInNoStopZone;
    public String searchId;
    public String specialPoiList;
    @SerializedName("sub_poi_list")
    public ArrayList<RpcPoi> sub_poi_list;

    public String toString() {
        return "RpcPoi{base_info=" + this.base_info + ", extend_info=" + this.extend_info + ", sub_poi_list=" + this.sub_poi_list + ", discount_poi=" + this.discount_poi + ", geofence=" + Arrays.toString(this.geofence) + ", specialPoiList='" + this.specialPoiList + '\'' + ", curTimeMills=" + this.curTimeMills + ", searchId='" + this.searchId + '\'' + ", isInNoStopZone='" + this.isInNoStopZone + '\'' + ", isDiscountPoi='" + this.isDiscountPoi + '\'' + '}';
    }
}
