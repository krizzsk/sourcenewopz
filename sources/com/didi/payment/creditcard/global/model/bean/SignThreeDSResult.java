package com.didi.payment.creditcard.global.model.bean;

import com.didi.payment.creditcard.global.model.ThreeDSInfo;
import com.google.gson.annotations.SerializedName;

public class SignThreeDSResult extends BaseResult {
    @SerializedName("extraValueMap")
    public ThreeDSInfo extraValueMap;
}
