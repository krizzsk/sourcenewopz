package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EstimateGroupModel implements BffGsonStruct {
    @SerializedName("items")
    public List<EstimateItemModel> estimateItems;
    @SerializedName("title")
    public String title;
}
