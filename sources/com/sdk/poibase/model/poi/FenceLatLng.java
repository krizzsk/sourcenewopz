package com.sdk.poibase.model.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FenceLatLng implements Serializable {
    @SerializedName("lat")
    public double lat;
    @SerializedName("lng")
    public double lng;

    public FenceLatLng(double d, double d2) {
        this.lat = d;
        this.lng = d2;
    }

    public String toString() {
        return "{lat=" + this.lat + ", lng=" + this.lng + '}';
    }
}
