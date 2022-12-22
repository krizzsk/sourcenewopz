package com.didi.travel.psnger.model.response.anycar;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AnyCarConfigModel implements BffGsonStruct {
    public static final int MULTI = 1;
    public static final int REC = 0;
    public static final int SINGLE = 2;
    @SerializedName("available_status")
    public int carAvailable;
    @SerializedName("business_id")
    public int carBussinessId;
    @SerializedName("combo_type")
    public int carComboType;
    @SerializedName("car_group_area")
    public int carGroupArea;
    @SerializedName("require_level")
    public int carLevel;
    @SerializedName("map_car_icon")
    public String carMapIconUrl;
    @SerializedName("product_id")
    public int carProductId;
    @SerializedName("confirm_text")
    public String confirmText;
    @SerializedName("count_price_type")
    public int countPriceType;
    @SerializedName("direct_new_order")
    public int direct_new_order = 0;
    @SerializedName("enable_one_price_popup")
    public int enableFixedPricePopup = 1;
    @SerializedName("estimate_id")
    public String estimateId;
    @SerializedName("extra_data")
    public AnyCarExtraData extraData;
    @SerializedName("guide_type")
    public List<String> guideType;
    @SerializedName("select_default")
    public int selectDefault;
    @SerializedName("single_car_select")
    public int singleCarSelect;
    @SerializedName("unique_id")
    public String uniqueId;
    @SerializedName("unavailable_toast_text")
    public String unvailableToastText;
    @SerializedName("use_expo_intercept_popup")
    public int use_expo_intercept_popup = 0;

    public boolean isEnableFixedPricePopup() {
        return this.enableFixedPricePopup != 0;
    }

    public boolean isDefaultSelect() {
        return this.selectDefault != 0;
    }
}
