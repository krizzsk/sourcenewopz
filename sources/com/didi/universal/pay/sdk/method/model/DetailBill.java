package com.didi.universal.pay.sdk.method.model;

import com.didi.universal.pay.sdk.model.BillMarketing;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DetailBill implements Serializable {
    public static final int NO_PASS_TYPE_AUTO = 1;
    public static final int NO_PASS_TYPE_MANUAL = 2;
    public static final int NO_PASS_TYPE_NONE = 0;
    @SerializedName("deduction_list")
    public DeductionInfo[] deductions;
    @SerializedName("external_channel_list")
    public UniversalPayChannelResponse[] externalChannels;
    @SerializedName("internal_channel_list")
    public UniversalPayChannelResponse[] internalChannels;
    @SerializedName("marketing")
    public BillMarketing[] marketing;
    @SerializedName("nopass_type")
    public int noPassType;
    @SerializedName("pay_btn_title")
    public String payBtnTitle;
    @SerializedName("pay_enable")
    public int payEnable;
    @SerializedName("payee_data")
    public Payee payee;
}
