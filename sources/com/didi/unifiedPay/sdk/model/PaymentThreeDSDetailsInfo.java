package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import global.didi.pay.threeds.model.Adyen3DSModel;

public class PaymentThreeDSDetailsInfo {
    public static final int RESULT_3DS = 2;
    public static final int RESULT_POLLING = 1;
    @SerializedName("3ds")
    public Adyen3DSModel adyen3DSModel;
    @SerializedName("polling_frequency")
    public int mPollingInterval = 1;
    @SerializedName("polling_times")
    public int mPollingTimes = 15;
    @SerializedName("3ds_result")
    public int threeDSResult;
}
