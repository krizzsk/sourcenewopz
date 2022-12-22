package com.didi.payment.utilities.resp;

import com.didi.payment.commonsdk.fastpay.FastPayData;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CsGetBillResp extends WBaseResp {
    public static final int BOLETO_TYPE_GENERAL = 1;
    public Data data;

    public static class Data implements Serializable {
        public String amount;
        public long amountCent;
        public double amountInDouble;
        public String amountInputSubTitle;
        public String barCode;
        public String bizContent;
        public int boletoType;
        @SerializedName("cashBack")
        public String cashBack;
        public String currencySymbol;
        public String dueDate;
        @SerializedName("fastPayInfo")
        public FastPayData fastPayData;
        public boolean isNightLimitHit;
        public BoletoBillLimitRiskDetailVo limitRiskDetail;
        public String linkUrl;
        public long maxBillAmountLimit;
        public String metadata;
        public long minBillAmountLimit;
        public boolean needToJumpZeroBill;
        public String orderId;
        public String payee;
    }
}
