package com.didi.travel.psnger.model.response.estimate;

import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.annotations.SerializedName;

public class CarDetailFeeDescModel {
    @SerializedName("content")
    public GlobalRichInfo DetailDescContent;
    @SerializedName("title")
    public GlobalRichInfo detailDescTitle;
}
