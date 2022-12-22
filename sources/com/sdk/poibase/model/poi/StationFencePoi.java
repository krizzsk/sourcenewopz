package com.sdk.poibase.model.poi;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.RpcPoi;
import java.io.Serializable;
import java.util.ArrayList;

public class StationFencePoi implements Serializable {
    @SerializedName("area_rec_points")
    public ArrayList<RpcPoi> areaRecPoi;
    @SerializedName("is_default_selected")
    public String defaultelected;
    @SerializedName("fence_info")
    public FenceInfo fenceInfo;
    @SerializedName("function_area")
    public String functionArea;

    public String toString() {
        return "StationFencePoi{functionArea='" + this.functionArea + '\'' + ", defaultelected='" + this.defaultelected + '\'' + ", fenceInfo=" + this.fenceInfo + ", areaRecPoi=" + this.areaRecPoi + '}';
    }
}
