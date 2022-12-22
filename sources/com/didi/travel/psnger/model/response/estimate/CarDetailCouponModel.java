package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.annotations.SerializedName;

public class CarDetailCouponModel implements BffGsonStruct {
    @SerializedName("rich_text")
    public GlobalRichInfo couponText;
    @SerializedName("rich_value")
    public GlobalRichInfo couponValue;
}
