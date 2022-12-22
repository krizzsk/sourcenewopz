package com.didi.travel.psnger.model.response;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MapModel implements BffGsonStruct {
    @SerializedName("line_info")
    public List<MapLineInfo> lineInfos;
    @SerializedName("marker_info")
    public List<MarkerInfo> markerInfos;
}
