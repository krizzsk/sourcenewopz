package com.sdk.poibase.model.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SpecialPoiGuidance implements Serializable {
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

    public String toString() {
        return "SpecialPoiGuidance{title='" + this.title + '\'' + ", icon='" + this.icon + '\'' + ", description='" + this.description + '\'' + ", guidance='" + this.guidance + '\'' + '}';
    }
}
