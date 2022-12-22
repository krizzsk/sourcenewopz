package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class CarDetailModel implements BffGsonStruct {
    @SerializedName("car_desc")
    public String carDesc;
    @SerializedName("info")
    public CarDetailFeeInfoModel carDetailFeeInfo;
    @SerializedName("unique_id")
    public String carDetailUid;
    @SerializedName("eta_desc")
    public String carEta;
    @SerializedName("icon")
    public String carIcon;
    @SerializedName("name")
    public String carName;
    @SerializedName("seat_count_icon")
    public String carSeatIcon;
    @SerializedName("seat_count_desc")
    public String carSeatNum;
    @SerializedName("two_price_info")
    public CarDetailTwoPriceModel carTwoPrice;
    public boolean isSelected = false;
}
