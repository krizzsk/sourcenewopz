package com.didi.travel.psnger.model.response.newbubbleParams;

import com.google.gson.annotations.SerializedName;

public class ActionEvent {
    @SerializedName("event_type")
    public int eventType;
    @SerializedName("params_model")
    public ParamsModel paramsModel;
}
