package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class BasicBill implements Serializable {
    private static final int AMOUNT = 1;
    private static final String LEFT_FLAG = "0";
    private static final int MARK = 2;
    private static final String RIGHT_FLAG = "1";
    private static final int SPLICE = 3;
    private static final int SYMBOL = 0;
    @SerializedName("action_type")
    public ActionType[] actionTypes;
    @SerializedName("bill_text")
    public String billText;
    @SerializedName("currency_pos")
    public int currencyPos;
    @SerializedName("currency_symbol")
    public String currencySymbol;
    @SerializedName("extra")
    public HashMap extra;
    @SerializedName("fee_desc_left")
    public String leftDes;
    @SerializedName("need_pay_fee_text_display")
    public String needPayFeeTextDisplay;
    @SerializedName("need_pay_fee_text_split")
    public List<String> needPayFeeTextSplit;
    @SerializedName("need_pay_fee_text")
    public String need_pay_fee_text;
    @SerializedName("pay_fee_desc_left")
    public String pay_fee_desc_left;
    @SerializedName("pay_fee_desc_right")
    public String pay_fee_desc_right;
    @SerializedName("fee_desc_right")
    public String rightDes;
    @SerializedName("should_pay_fee")
    public long shouldPayFee;
    @SerializedName("should_pay_fee_display")
    public String shouldPayFeeDisplay;
    @SerializedName("should_pay_fee_split")
    public List<String> shouldPayFeeSplit;
    @SerializedName("total_fee")
    public long totalFee;
    @SerializedName("total_fee_display")
    public String totalFeeDisplay;
    @SerializedName("total_fee_split")
    public List<String> totalFeeSplit;
    @SerializedName("total_fee_text")
    public String totalFeeText;
    @SerializedName("total_fee_include_text")
    public String total_fee_include_text;
    @SerializedName("total_fee_title")
    public String total_fee_title;

    public String getLeftDes() {
        if (!isArrayEmptyOrError(this.totalFeeSplit)) {
            return this.leftDes;
        }
        if (!isDesLeft(this.totalFeeSplit.get(2)) || this.totalFeeSplit.get(0) == null) {
            return "";
        }
        return this.totalFeeSplit.get(0);
    }

    public String getRightDes() {
        if (!isArrayEmptyOrError(this.totalFeeSplit)) {
            return this.rightDes;
        }
        if (isDesLeft(this.totalFeeSplit.get(2)) || this.totalFeeSplit.get(0) == null) {
            return "";
        }
        return this.totalFeeSplit.get(0);
    }

    public String getTotalFeeText() {
        if (isArrayEmptyOrError(this.totalFeeSplit)) {
            return this.totalFeeSplit.get(1) != null ? this.totalFeeSplit.get(1) : this.totalFeeText;
        }
        return this.totalFeeText;
    }

    public String getNeedPayFee() {
        if (isArrayEmptyOrError(this.shouldPayFeeSplit)) {
            return this.needPayFeeTextSplit.get(1) != null ? this.needPayFeeTextSplit.get(1) : this.need_pay_fee_text;
        }
        return this.need_pay_fee_text;
    }

    private boolean isArrayEmptyOrError(List list) {
        return list != null && !list.isEmpty() && list.size() == 4;
    }

    private boolean isDesLeft(String str) {
        return "0".equals(str);
    }
}
