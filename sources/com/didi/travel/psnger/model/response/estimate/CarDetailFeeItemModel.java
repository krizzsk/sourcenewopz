package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.annotations.SerializedName;

public class CarDetailFeeItemModel implements BffGsonStruct {
    @SerializedName("rich_text")
    public GlobalRichInfo feeItemText;
    @SerializedName("rich_value")
    public GlobalRichInfo feeItemValue;
}
