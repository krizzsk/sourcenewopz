package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PrepayInfo implements Serializable {
    public static final int TYPE_ALREADY_PAYED = 4;
    public static final int TYPE_EXTERNAL_PAY = 1;
    public static final int TYPE_INTERNAL_PAYED = 2;
    public static final int TYPE_NOPW_PAYED = 3;
    public static final int TYPE_PAY_CLOSED = 5;
    public static final int TYPE_PAY_TIME_OUT = 0;
    public static final int TYPE_PAY_VERIFY_PSD = -1;
    @SerializedName("cmb_params")
    public BankModel cmbParams;
    @SerializedName("ddpay_params")
    public DidipayModel ddpayModel;
    @SerializedName("pay_channel")
    public int pay_channel;
    @SerializedName("paypay_params")
    public PayPayModel paypayParams;
    @SerializedName("qqmoney_params")
    public QQPayModel qqParams;
    @SerializedName("result_type")
    public int resultType;
    public VisaPayModel visaPayModel;
    @SerializedName("weixin_params")
    public WeixinPayModel weixinParams;
    @SerializedName("zfb_params")
    public AliPayModel zfbParams;
}
