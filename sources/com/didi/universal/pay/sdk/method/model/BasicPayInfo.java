package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public class BasicPayInfo implements Serializable {
    public static final int BLOCK_TYPE_ADD = 4;
    public static final int BLOCK_TYPE_DEFAULT = 0;
    public static final int BLOCK_TYPE_NO_ONLINE_PAY = 5;
    public static final int BLOCK_TYPE_OBJECTION = 1;
    public static final int BLOCK_TYPE_PIN_ERR = 3;
    public static final int BLOCK_TYPE_RISK = 2;
    @SerializedName("bill_basic")
    public BasicBill billBasic;
    @SerializedName("block_type")
    public int blockType;
    @SerializedName("bill_confirm_info")
    public BillConfirm confirmInfo;
    @SerializedName("didi_credit_ad")
    public CreditAdd creditAdd;
    @SerializedName("deduction_list")
    public DeductionInfo[] deductions;
    @SerializedName("downgrade")
    public int downgrade;
    @SerializedName("objection_info")
    public Map objectionInfo;
    @SerializedName("pay_status")
    public int payStatus;
    @SerializedName("pay_title")
    public String payTitle;
    @SerializedName("risk_info")
    public RiskInfo riskInfo;
    @SerializedName("pay_status_msg")
    public String statusMsg;
}
