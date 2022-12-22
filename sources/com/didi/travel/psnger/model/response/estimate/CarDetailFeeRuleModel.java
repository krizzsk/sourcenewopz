package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class CarDetailFeeRuleModel implements BffGsonStruct {
    @SerializedName("desc")
    public String feeRuleDesc;
    @SerializedName("link")
    public String feeRuleLink;
}
