package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BillConfirm implements Serializable {
    @SerializedName("confirm_text")
    public String confirmText;
    @SerializedName("total_fee_text")
    public String totalFeeText;
}
