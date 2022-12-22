package com.didi.travel.psnger.model.response;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NextNoSecretPay implements Serializable {
    @SerializedName("actual_pay_money")
    public String actual_pay_money = "";
    @SerializedName("fee_objection_entrance")
    public JsonElement chargeDissent;
    @SerializedName("fresh_msg")
    public String freshMsg = "";
    @SerializedName("order_pay_msg")
    public String orderPayMsg = "";
    @SerializedName("order_pay_status")
    public int orderPayStatus = 0;
    @SerializedName("order_pay_subject")
    public String orderPaySubject = "";
    @SerializedName("order_pay_title")
    public String orderPayTitle = "";
}
