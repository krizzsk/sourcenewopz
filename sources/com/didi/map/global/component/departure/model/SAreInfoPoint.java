package com.didi.map.global.component.departure.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SAreInfoPoint implements Serializable {
    @SerializedName("lat")
    public double lat;
    @SerializedName("lng")
    public double lng;
}
