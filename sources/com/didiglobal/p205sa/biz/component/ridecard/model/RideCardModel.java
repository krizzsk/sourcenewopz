package com.didiglobal.p205sa.biz.component.ridecard.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.RpcPoiExtendInfo;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.ridecard.model.RideCardModel */
public class RideCardModel implements Serializable {
    public Config config;
    @SerializedName("sug_intercept")
    public SugIntercept intercept;
    public Map map;
    public MessageBar messagebar;
    public RecommendDest recommendDest;

    /* renamed from: com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$Config */
    public static class Config implements Serializable {
        public int enableSafeTool;
        public int enableShowMap;
        public int enableWaypoint;
    }

    /* renamed from: com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$Destination */
    public static class Destination implements Serializable {
        @SerializedName("base_info")
        public RpcPoiBaseInfo base_info;
        @SerializedName("extend_info")
        public HomeExtendInfo extend_info;
    }

    /* renamed from: com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$HomeExtendInfo */
    public static class HomeExtendInfo extends RpcPoiExtendInfo {
        @SerializedName("multi_estimate_data")
        public Object estimateItemJson;
        @SerializedName("estimate_trace_id")
        public String estimateTraceId;
        @SerializedName("directcall_flag")
        public int flag;
        @SerializedName("max_distance_gap")
        public int maxDistanceGap;
        @SerializedName("directcall_srctag")
        public String oneKeySrcTag;
        @SerializedName("rec_start_points")
        public RpcPoi startAddress;
        @SerializedName("display_details")
        public LEGORichInfo subTitle;
    }

    /* renamed from: com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$Map */
    public static class Map implements Serializable {
        public String businessid;
        public String carIcon;
        public int carLevel;
    }

    /* renamed from: com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$MessageBar */
    public static class MessageBar implements Serializable {
        public String color_bg_end;
        public String color_bg_start;
        public String icon;
        public String link;
        public JsonObject log_data;
        public LEGORichInfo message;
    }

    /* renamed from: com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$RecommendDest */
    public static class RecommendDest implements Serializable {
        @SerializedName("rec_destination_new")
        public List<Destination> destinationList;
        public String search_id;
    }

    /* renamed from: com.didiglobal.sa.biz.component.ridecard.model.RideCardModel$SugIntercept */
    public static class SugIntercept implements Serializable {
        public JsonObject intercept_data;
        public int is_intercept;
    }
}
