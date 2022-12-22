package com.didi.travel.psnger.model.response.newbubbleParams;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class ShowEvent {
    @SerializedName("event_id")
    public String eventId;
    @SerializedName("event_params")
    public JsonObject params;
}
