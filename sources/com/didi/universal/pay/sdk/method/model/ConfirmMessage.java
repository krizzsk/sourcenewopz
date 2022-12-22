package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ConfirmMessage implements Serializable {
    @SerializedName("button_cancel")
    public String buttonCancel;
    @SerializedName("button_confirm")
    public String buttonConfirm;
    @SerializedName("msg")
    public String msg;
    @SerializedName("tips")
    public String tips;
    @SerializedName("title")
    public String title;
    @SerializedName("total_fee")
    public String totalFee;
}
