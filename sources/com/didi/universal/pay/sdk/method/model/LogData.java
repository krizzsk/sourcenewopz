package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LogData implements Serializable {
    @SerializedName("act_id")
    public int actId;
    @SerializedName("trace_id")
    public String traceId;
}
