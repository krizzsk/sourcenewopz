package com.sdk.poibase.model.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

public class StationInfo implements Serializable {
    @SerializedName("bottom_text")
    public String bottomText;
    @SerializedName("exit_text")
    public String exitext;
    @SerializedName("function_area_list")
    public ArrayList<StationFencePoi> functionAreas;
    public int showStationInfo;
    @SerializedName("station_icon")
    public String stationIcon;
    @SerializedName("station_type")
    public int stationType;
    @SerializedName("top_title")
    public String topTitle;
    @SerializedName("welcome_text")
    public String welcomeText;

    public String toString() {
        return "StationInfo{stationType='" + this.stationType + '\'' + ", stationIcon='" + this.stationIcon + '\'' + ", topTitle='" + this.topTitle + '\'' + ", welcomeText='" + this.welcomeText + '\'' + ", bottomText='" + this.bottomText + '\'' + ", exitext='" + this.exitext + '\'' + ", functionAreas=" + this.functionAreas + '}';
    }
}
