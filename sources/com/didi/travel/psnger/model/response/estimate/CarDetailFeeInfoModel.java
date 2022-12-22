package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarDetailFeeInfoModel implements BffGsonStruct {
    @SerializedName("coupon")
    public List<CarDetailCouponModel> carDeatilCoupon;
    @SerializedName("desc")
    public CarDetailFeeDescModel carDetailFeeDesc;
    @SerializedName("rule")
    public CarDetailFeeRuleModel carDetailFeeRule;
    @SerializedName("fees")
    public List<CarDetailFeeItemModel> feesList;
}
