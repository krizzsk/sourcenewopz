package com.didi.unifiedPay.sdk.model;

import com.didi.unifiedPay.component.model.BillMarketing;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DetailBill implements Serializable {
    public static final int NO_PASS_TYPE_AUTO = 1;
    public static final int NO_PASS_TYPE_MANUAL = 2;
    public static final int NO_PASS_TYPE_NONE = 0;
    @SerializedName("deduction_list")
    public DeductionInfo[] deductions;
    @SerializedName("external_channel_list")
    public ExternalPayChannel[] externalChannels;
    @SerializedName("frozen_link")
    public String frozenLink;
    @SerializedName("frozen_title")
    public String frozenTitle;
    @SerializedName("group")
    public PayMethodGroup[] group;
    public int holdOnFlag;
    @SerializedName("internal_channel_list")
    public InternalPayChannel[] internalChannels;
    @SerializedName("marketing")
    public BillMarketing[] marketing;
    @SerializedName("merchant_info")
    public MerchantInfo merchantInfo;
    @SerializedName("nopass_type")
    public int noPassType;
    @SerializedName("pay_btn_title")
    public String payBtnTitle;
    @SerializedName("pay_enable")
    public int payEnable;
    @SerializedName("payee_data")
    public Payee payee;
    @SerializedName("qr_code_data")
    public String pixCode;
    @SerializedName("top_copy_writing")
    public String topCopyWriting;
}
