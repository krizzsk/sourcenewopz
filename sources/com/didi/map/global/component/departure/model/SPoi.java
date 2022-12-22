package com.didi.map.global.component.departure.model;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.RpcPoi;
import java.io.Serializable;
import java.util.List;

public class SPoi implements Serializable {
    @SerializedName("area_info")
    public SAreaInfo area;
    @SerializedName("pick_points")
    public List<RpcPoi> list;
}
