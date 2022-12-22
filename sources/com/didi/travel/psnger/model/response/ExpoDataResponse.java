package com.didi.travel.psnger.model.response;

import com.android.didi.bfflib.business.BffBaseObject;
import com.didi.travel.psnger.model.response.estimate.MultiEstimateData;
import com.google.gson.annotations.SerializedName;

public class ExpoDataResponse extends BffBaseObject {
    @SerializedName(alternate = {"data"}, value = "passenger_MultiEstimatePrice")
    public MultiEstimateData multiEstimateData;
}
