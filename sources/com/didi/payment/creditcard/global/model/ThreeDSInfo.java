package com.didi.payment.creditcard.global.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ThreeDSInfo implements Serializable {
    @SerializedName("sessionId")
    public String sessionId;
    @SerializedName("threeDSAction")
    public String threeDSAction;
    @SerializedName("threeDSShopper")
    public String threeDSShopper;
    @SerializedName("threeDSVendor")
    public String threeDSVendor;
}
