package com.didi.travel.psnger.model.response.estimate;

import com.google.gson.annotations.SerializedName;

public class SelectedValueParams {
    @SerializedName("car_pool")
    public int carPool;
    @SerializedName("carpool_order_scene")
    public int carpoolOrderScene;
    @SerializedName("combo_id")
    public int comboId;
    @SerializedName("combo_type")
    public int comboType;
    @SerializedName("custom_feature")
    public String customFeature;
    @SerializedName("dispatch_fee")
    public String dispatchFee;
    @SerializedName("pool_seat")
    public int poolSeat;
    @SerializedName("count_price_type")
    public int seatPoolCountType;
    @SerializedName("estimate_id")
    public String seatPoolEstimateId;
    @SerializedName("estimate_price")
    public float seatPoolEstimatePrice;
}
