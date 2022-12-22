package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.Cybs3DSModel;
import java.io.Serializable;

public class PrepayInfo implements Serializable {
    public static final int TYPE_ALREADY_PAYED = 4;
    public static final int TYPE_EXTERNAL_PAY = 1;
    public static final int TYPE_INTERNAL_PAYED = 2;
    public static final int TYPE_NEED_PASSWORD = 6;
    public static final int TYPE_NOPW_PAYED = 3;
    public static final int TYPE_PAY_CLOSED = 5;
    public static final int TYPE_PAY_TIME_OUT = 0;
    @SerializedName("3ds")
    public Adyen3DSModel adyen3DSModel;
    @SerializedName("cmb_params")
    public BankModel cmbParams;
    @SerializedName("three_ds_v2")
    public Cybs3DSModel cybs3DSModel;
    @SerializedName("ddpay_params")
    public DidipayModel ddpayModel;
    @SerializedName("jump_to_h5")
    public boolean jump_to_h5;
    @SerializedName("password")
    public PasswordModel mPasswordModel;
    @SerializedName("polling_frequency")
    public int mPollingInterval = 1;
    @SerializedName("polling_times")
    public int mPollingTimes = 15;
    @SerializedName("no_need_query_pay")
    public boolean no_need_query_pay;
    @SerializedName("third_party_params")
    public String offline_pay_params;
    @SerializedName("pay_channel")
    public int pay_channel;
    @SerializedName("paypay_params")
    public PayPayModel paypayParams;
    @SerializedName("qr_code_data")
    public String pixCode;
    @SerializedName("qqmoney_params")
    public QQPayModel qqParams;
    @SerializedName("result_type")
    public int resultType;
    public VisaPayModel visaPayModel;
    @SerializedName("weixin_params")
    public WeixinPayModel weixinParams;
    @SerializedName("zfb_params")
    public AliPayModel zfbParams;

    public class OfflinePayModel {
        public String h5_url;

        public OfflinePayModel() {
        }
    }
}
