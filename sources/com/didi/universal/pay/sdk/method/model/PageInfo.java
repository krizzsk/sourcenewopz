package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PageInfo implements Serializable {
    @SerializedName("button_err")
    public String buttonErr;
    @SerializedName("button_ok")
    public String buttonOk;
    @SerializedName("confirm_msg")
    public ConfirmMessage confirmMsg;
    @SerializedName("objection_msg")
    public String objectionMsg;
    @SerializedName("objection_title")
    public String objectionTitle;
    @SerializedName("page_title")
    public String pageTitle;
    public long total_fee;
}
