package com.sdk.poibase.model.guideentrance;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;

public class StreetCheckResult extends HttpResultBase {
    @SerializedName("viewenable")
    public int viewenable;

    public String toString() {
        return "StreetCheckResult{viewenable=" + this.viewenable + '}';
    }
}
