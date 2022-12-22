package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.json.JSONObject;

public class PayInfo implements Serializable {
    @SerializedName("bill_basic")
    public BasicBill billBasic;
    @SerializedName("bill_detail")
    public DetailBill billDetail;
    @SerializedName("objection_info")
    public JSONObject objectionInfo;
    @SerializedName("out_trade_id")
    public String outTradeId;
    @SerializedName("pay_status")
    public int payStatus;
    @SerializedName("pay_status_detail")
    public int payStatusDetail;
    @SerializedName("pay_title")
    public String pay_title;
    @SerializedName("pay_status_msg")
    public String statusMsg;
    @SerializedName("toast_message")
    public String toast_message;
}
