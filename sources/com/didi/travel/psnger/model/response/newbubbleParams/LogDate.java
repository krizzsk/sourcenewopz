package com.didi.travel.psnger.model.response.newbubbleParams;

import com.google.gson.annotations.SerializedName;

public class LogDate {
    @SerializedName("dismiss_event")
    public DismissEvent dismissEvent;
    @SerializedName("show_event")
    public ShowEvent showEvent;
}
