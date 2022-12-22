package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarConfigModel implements BffGsonStruct {
    @SerializedName("available_status")
    public int carAvailable;
    @SerializedName("business_id")
    public int carBussinessId;
    @SerializedName("radius")
    public int carCircleRadius;
    @SerializedName("combo_type")
    public int carComboType;
    @SerializedName("hold_time")
    public int carHoldTime;
    @SerializedName("require_level")
    public int carLevel;
    @SerializedName("map_car_icon")
    public String carMapIconUrl;
    @SerializedName("product_id")
    public int carProductId;
    @SerializedName("wait_time")
    public int carWaitTime;
    @SerializedName("carpool_show")
    public int carpoolShow;
    @SerializedName("combo_id")
    public int comboId;
    @SerializedName("confirm_text")
    public String confirmText;
    @SerializedName("count_price_type")
    public int countPriceType;
    @SerializedName("direct_new_order")
    public int direct_new_order = 0;
    @SerializedName("dup_bubble_msg")
    public String dupBubbleMsg;
    @SerializedName("enable_one_price_popup")
    public int enableFixedPricePopup = 1;
    @SerializedName("estimate_id")
    public String estimateId;
    @SerializedName("extra_data")
    public CarExtraDataModel extraData;
    @SerializedName("guide_state")
    public int guideState;
    @SerializedName("guide_type")
    public List<String> guideType;
    @SerializedName("request_text")
    public String requestText;
    @SerializedName("scene_type")
    public int scaneType;
    @SerializedName("select_default")
    public String selectDefault;
    @SerializedName("unique_id")
    public String uniqueId;
    @SerializedName("unavailable_toast_text")
    public String unvailableToastText;
    @SerializedName("use_expo_intercept_popup")
    public int use_expo_intercept_popup = 0;

    public boolean isEnableFixedPricePopup() {
        return this.enableFixedPricePopup != 0;
    }
}
