package com.didi.payment.transfer.common.model;

import com.google.gson.annotations.SerializedName;

public class FuncButton {
    public String label;
    @SerializedName("nlabel")
    public String newLabel;
    @SerializedName("url")
    public String routerUrl;
}
