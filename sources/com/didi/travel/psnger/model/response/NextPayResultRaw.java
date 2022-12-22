package com.didi.travel.psnger.model.response;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: NextPayResult */
class NextPayResultRaw implements Serializable {
    @SerializedName("coupon_fee")
    public String actual_deduction;
    @SerializedName("coupon_fee_display_string")
    public String actual_deduction_display;
    @SerializedName("actual_pay_money")
    public String actual_pay_money;
    @SerializedName("actual_pay_money_display_string")
    public String actual_pay_money_display;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
    @SerializedName("oid")
    public String oid = "";
    @SerializedName("pay_info")
    public String payInfo;
    @SerializedName("pay_order_subtitle")
    public String payOrderSubTitle;
    @SerializedName("pay_order_title")
    public String payOrderTitle;
    @SerializedName("share_coupon")
    public JsonElement shareCoupon;
    @SerializedName("total_fee")
    public String total_fee;
    @SerializedName("total_fee_display_string")
    public String total_fee_display;
    @SerializedName("trade_status")
    public int tradeStatus;

    NextPayResultRaw() {
    }

    public String toString() {
        return "NextPayResultRaw{oid='" + this.oid + '\'' + ", errno=" + this.errno + ", errmsg='" + this.errmsg + '\'' + ", tradeStatus=" + this.tradeStatus + ", payOrderTitle='" + this.payOrderTitle + '\'' + ", payOrderSubTitle='" + this.payOrderSubTitle + '\'' + ", actual_pay_money='" + this.actual_pay_money + '\'' + ", payInfo='" + this.payInfo + '\'' + ", shareCoupon=" + this.shareCoupon + '}';
    }
}
