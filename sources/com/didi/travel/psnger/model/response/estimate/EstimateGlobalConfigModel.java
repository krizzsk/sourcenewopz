package com.didi.travel.psnger.model.response.estimate;

import com.google.gson.annotations.SerializedName;

public class EstimateGlobalConfigModel {
    @SerializedName("estimate_trace_id")
    public String globalEstimateTraceId;
    @SerializedName("guideState")
    public int guideState;
    @SerializedName("select_item_commit_url")
    public String selectItemCommitUrl;
    @SerializedName("transparent_data")
    public String transparentData;
    @SerializedName("ui_config")
    public UIConfig uiConfig;

    public static class UIConfig {
        @SerializedName("car_scale_factor")
        public double carScaleFactor;
        @SerializedName("mask_unselected_cards")
        public int cardsHasMask;
    }
}
