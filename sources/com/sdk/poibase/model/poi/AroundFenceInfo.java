package com.sdk.poibase.model.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AroundFenceInfo implements Serializable {
    @SerializedName("fence_id")
    public String fenceId;
    @SerializedName("no_parking_lat")
    public double noParkingLat;
    @SerializedName("no_parking_lng")
    public double noParkingLng;
    @SerializedName("polygon")
    public List<FenceLatLng> polygon;

    public String toString() {
        return "FenceInfo{fenceId='" + this.fenceId + '\'' + ", polygon=" + this.polygon + '}';
    }
}
