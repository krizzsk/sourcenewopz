package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import global.didi.pay.threeds.model.Adyen3DSModel;
import java.io.Serializable;

public class PayStatus implements Serializable {
    public static final int PAY_STATUS_3DS = 11;
    public static final int PAY_STATUS_CLOSED = 7;
    public static final int PAY_STATUS_NEXT_TRIP = 10;
    public static final int PAY_STATUS_NOPWD_PAYING = 2;
    public static final int PAY_STATUS_NOT_PAY = 1;
    public static final int PAY_STATUS_PAYED = 3;
    public static final int PAY_STATUS_PAYED_OFF_LINE = 5;
    public static final int PAY_STATUS_PAY_FAILED = 4;
    public static final int PAY_STATUS_UNKNOW = 0;
    public static final int PAY_STATUS_UNSAFE = 6;
    @SerializedName("action_type")
    public ActionType[] actionTypes;
    @SerializedName("bill_basic")
    public PayStatusBasicBill billBasic;
    @SerializedName("event_info")
    public EventInfoModel eventInfo;
    @SerializedName("3ds")
    public Adyen3DSModel mAdyen3DSModel;
    @SerializedName("prepay_result")
    public OfflinePayStatus mOfflinePayStatus;
    @SerializedName("pay_status")
    public int payStatus;
    @SerializedName("pay_status_detail")
    public int payStatusDetail;
    @SerializedName("should_pay_fee")
    public int shouldPayFee;
    @SerializedName("pay_status_msg")
    public String statusMsg;
    @SerializedName("total_fee")
    public int totalFee;
}
