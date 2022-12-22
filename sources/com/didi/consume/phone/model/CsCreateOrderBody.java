package com.didi.consume.phone.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CsCreateOrderBody implements Serializable {
    public String extraData;
    public Boolean fraudStatus;
    @SerializedName("operatorId")
    public String operatorId;
    public int orderType = -1;
    @SerializedName("phoneCountryCode")
    public String phoneCountryCode;
    @SerializedName("phoneNumber")
    public String phoneNumber;
    public transient Boolean useFastPay;
}
