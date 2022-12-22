package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.MapLineInfo;
import com.didi.travel.psnger.model.response.MarkerInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MapInfoModel implements BffGsonStruct {
    public static final int ARC_LINE = 1;
    public static final int MINI_BUS = 4;
    public static final int NORMAL_LINE = 0;
    public static final int NO_LINE = 3;
    public static final int START_CIRCLE = 2;
    @SerializedName("confirm_pickup_point_route_type")
    public int confirmPickupRouteType;
    @SerializedName("confirm_pickup_point_sub_text")
    public String confirmPickupSubText = "";
    @SerializedName("enable_passing_point")
    public int enablePassingPoint;
    @SerializedName("line_info")
    public List<MapLineInfo> lineInfo;
    @SerializedName("marker_info")
    public List<MarkerInfo> markerInfo;
    @SerializedName("estimate_route_type")
    public int routeType = 0;
    @SerializedName("start_point_text")
    public GlobalRichInfo startPointText;

    public boolean isEnablePassingPoint() {
        return this.enablePassingPoint != 0;
    }

    public boolean isConfirmPickupShowCircle() {
        return this.confirmPickupRouteType == 1;
    }
}
