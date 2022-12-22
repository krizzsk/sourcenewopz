package com.sdk.poibase.model.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;

public class GeoFence implements Serializable {
    @SerializedName("id")

    /* renamed from: id */
    public String[] f56003id;

    public String toString() {
        return "GeoFence{id=" + Arrays.toString(this.f56003id) + '}';
    }
}
