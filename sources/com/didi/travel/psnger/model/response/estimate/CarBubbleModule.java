package com.didi.travel.psnger.model.response.estimate;

import com.didi.travel.psnger.model.response.newbubbleParams.BubbleLocation;
import com.didi.travel.psnger.model.response.newbubbleParams.Strategy;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarBubbleModule {
    @SerializedName("location_list")
    public List<BubbleLocation> locationList;
    @SerializedName("strategy")
    public Strategy strategy;
}
