package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class CarDetailTwoPriceModel implements BffGsonStruct {
    @SerializedName("available")
    public boolean twoPriceAvailable;
    @SerializedName("matched_text")
    public String twoPriceMactch;
    @SerializedName("unmatched_text")
    public String twoPriceUnmatch;
}
