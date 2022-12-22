package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PayStatus implements Serializable {
    public static final int PAY_INSUFFICIENT = 100;
    public static final int PAY_STATUS_CLOSED = 7;
    public static final int PAY_STATUS_NEED_QUERY = 8;
    public static final int PAY_STATUS_NOPWD_PAYING = 2;
    public static final int PAY_STATUS_NOT_PAY = 1;
    public static final int PAY_STATUS_PAYED = 3;
    public static final int PAY_STATUS_PAYED_OFF_LINE = 5;
    public static final int PAY_STATUS_PAY_FAILED = 4;
    public static final int PAY_STATUS_UNKNOW = 0;
    public static final int PAY_STATUS_UNSAFE = 6;
    @SerializedName("bill_basic")
    public BasicBill basicBill;
    @SerializedName("pay_status")
    public int payStatus;
    @SerializedName("pay_status_detail")
    public int payStatusDetail;
    @SerializedName("pay_status_msg")
    public String statusMsg;
}
