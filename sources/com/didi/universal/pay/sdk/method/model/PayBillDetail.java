package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class PayBillDetail {
    @SerializedName("bottom_explain")
    public String bottomExplain;
    @SerializedName("deduction_list")
    public DeductionDetail[] deductionList;
    @SerializedName("deduction_total")
    public String deductionTotal;
    @SerializedName("deduction_total_left")
    public String deductionTotalLeft;
    @SerializedName("deduction_total_right")
    public String deductionTotalRight;
    @SerializedName("extra")
    public Map extra;
    @SerializedName("fee_detail_list")
    public List<FeeDetail> feeDetailList;
    @SerializedName("is_nopass")
    public int isNopass;
    @SerializedName("pay_status")
    public int payStatus;
    @SerializedName("question_url")
    public String questionUrl;
    @SerializedName("top_explain")
    public String topExplain;
    @SerializedName("total_fee")
    public String totalFee;
    @SerializedName("total_fee_desc_left")
    public String totalFeeDescLeft;
    @SerializedName("total_fee_desc_right")
    public String totalFeeDescRight;
}
