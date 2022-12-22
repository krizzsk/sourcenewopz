package com.didi.travel.psnger.model.response.anycar;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.estimate.FormOperationModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AnyCarGlobalConfig implements BffGsonStruct {
    @SerializedName("confirm_btn_text")
    public String confirmBtnText;
    @SerializedName("estimate_trace_id")
    public String globalEstimateTraceId;
    @SerializedName("form_operation")
    public FormOperationModel mFormOperationModel;
    @SerializedName("map_info")
    public AnyCarMapInfo mapInfo;
    public AnyCarPreference preference;
    @SerializedName("select_item_commit_url")
    public String selectItemCommitUrl;
    @SerializedName("slider_tips")
    public String slideTips;

    public static class AnyCarMapInfo implements BffGsonStruct {
        @SerializedName("confirm_pickup_point_route_type")
        public int confirmPickupRouteType;
        @SerializedName("confirm_pickup_point_sub_text")
        public String confirmPickupSubText = "";
        @SerializedName("enable_passing_point")
        public int enablePassingPoint;
        @SerializedName("map_car_icon")
        public String mapCarIcon;
        @SerializedName("start_point_text")
        public GlobalRichInfo startPointText;
    }

    public static class AnyCarPreference implements BffGsonStruct {
        @SerializedName("collapse_title")
        public LEGORichInfo collapseTitle;
        @SerializedName("is_expand")
        public int isExpand = 0;
        public List<AnyCarOptions> options;
        public LEGORichInfo title;
        @SerializedName("user_type")
        public int userType = 0;

        public static class AnyCarOptions implements BffGsonStruct {
            public String title;
            public int type;
        }
    }
}
