package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CreditAdd implements Serializable {
    @SerializedName("image")
    public String imageUrl;
    @SerializedName("ltext")
    public String leftBtnText;
    @SerializedName("log_data")
    public LogData logData;
    @SerializedName("rtext")
    public String rightBtnText;
    @SerializedName("rurl")
    public String rightBtnUrl;
}
