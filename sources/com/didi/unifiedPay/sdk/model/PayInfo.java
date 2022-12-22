package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class PayInfo implements Serializable {
    @SerializedName("app_id")
    public String appId;
    @SerializedName("bill_basic")
    public BasicBill billBasic;
    @SerializedName("bill_detail")
    public DetailBill billDetail;
    @SerializedName("cashier_product_id")
    public String cashier_product_id;
    @SerializedName("event_info")
    public EventInfoModel eventInfo;
    @SerializedName("is_hit_new_version_cashier_experiment")
    public int hitOptimizedCashier;
    @SerializedName("installment_plan")
    public List<InstallmentModel> installmentModel;
    @SerializedName("objection_info")
    public ObjectionInfo objectionInfo;
    @SerializedName("oid")
    public String oid;
    @SerializedName("out_trade_id")
    public String outTradeId;
    @SerializedName("pay_status")
    public int payStatus;
    @SerializedName("pay_status_color")
    public String payStatusColor;
    @SerializedName("pay_status_detail")
    public int payStatusDetail;
    @SerializedName("pay_status_link")
    public String payStatusLink;
    @SerializedName("pay_title")
    public String pay_title;
    @SerializedName("product_id")
    public String product_id;
    @SerializedName("marketing")
    public InstallmentRecommendModel recommendModel;
    @SerializedName("pay_status_msg")
    public String statusMsg;
    @SerializedName("toast_message")
    public String toast_message;
}
