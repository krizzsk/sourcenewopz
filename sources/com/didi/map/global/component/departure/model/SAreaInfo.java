package com.didi.map.global.component.departure.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SAreaInfo implements Serializable {
    @SerializedName("centre_point")
    public SAreInfoPoint centre_point;
    @SerializedName("id")

    /* renamed from: id */
    public String f25199id;
    @SerializedName("is_nearest")
    public int is_nearest;
    @SerializedName("name")
    public String name;
    @SerializedName("point_first")
    public int point_first;
}
