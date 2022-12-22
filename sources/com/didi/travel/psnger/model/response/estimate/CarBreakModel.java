package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class CarBreakModel implements BffGsonStruct {
    @SerializedName("delivery_info")
    public JsonObject carBreakDelivery;
    @SerializedName("package_info")
    public CarBreakMemberModel carBreakMember;
    @SerializedName("pin_info")
    public CarBreakPinInfo carBreakPinInfo;
    @SerializedName("carpool_seat_info")
    public CarBreakSeatModel carBreakSeat;
    @SerializedName("fare_confirm")
    public CarFareConfirmBreak carFareConfirm;
    @SerializedName("confirm_block_info")
    public CarBreakConfirmBlockInfoModel confirmBlockInfo;
    @SerializedName("offer_flex_price_scheme")
    public String offer_flex_price_scheme;
    @SerializedName("preorder_expo_intercept_info")
    public PreOrderExpoInterceptInfo preorderExpoInterceptInfo;
    @SerializedName("select_seat_scheme")
    public String seatSelectScheme;
}
