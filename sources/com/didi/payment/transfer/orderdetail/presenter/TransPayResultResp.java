package com.didi.payment.transfer.orderdetail.presenter;

import com.didi.payment.base.finResource.CommonResourceState;
import com.didi.payment.transfer.net.TransBaseResp;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class TransPayResultResp extends TransBaseResp {
    public static final int PAY_STATUS_FAILED = 2;
    public static final int PAY_STATUS_PROCESSING = 0;
    public static final int PAY_STATUS_SUCCESS = 1;
    public static final int PAY_STATUS_WAITING = 0;
    public static final int TOPUP_ORDER_STATUS_COMPLETE = 4;
    public static final int TOPUP_ORDER_STATUS_FAILED = 5;
    public PayResultData data;

    public static class ItemModel implements Serializable {
        public String color;
        public boolean isBold;
        public String title;
        public String value;
    }

    public static class PayResultData implements Serializable {
        public String amount;
        @SerializedName("cancelButton")
        public String cancelBtnText;
        @SerializedName("commonResourceState")
        public CommonResourceState commonResourceState;
        public String currencySymbol;
        public int orderType;
        @SerializedName("outTradeId")
        public String outTradeId;
        @SerializedName("payResult")
        public TopupResult payResult;
        public List<ItemModel> payeeStatement;
        public String payeeStatementTitle;
        public List<ItemModel> rechargeStatement;
        @SerializedName("rechargeStatementTitle")
        public String rechargeStatementTile;
        public String remarkText;
        @SerializedName("remindButton")
        public String remindBtnText;
        @SerializedName("title")
        public String resultMainTitle;
        @SerializedName("subTitle")
        public String resultSubTitle;
        @SerializedName("ruleLimitDetail")
        public WalletPayResultResp.RuleLimitDetailVo ruleLimitDetail;
        public boolean share;
        public String shareBannerText;
        public List<ItemModel> statement;
        public List<ItemModel> statementExtend;
        public int status;
        @SerializedName("subTitleBgColor")
        public String subTitleBgColor;
        @SerializedName("subTitleColor")
        public String subTitleColor;
        public List<TransferProcess> transferProcesses;
    }

    public static class RuleLimitDetailVo {
        @SerializedName("link")
        public String link;
        @SerializedName("text")
        public String text;
    }

    public static class TopupResult implements Serializable {
        @SerializedName("err_msg")
        public String errmsg;
        @SerializedName("pay_status")
        public int payStatus;
        public String reason;
    }

    public static class TransferProcess {
        public String subTitle;
        public String title;
        @SerializedName("color")
        public String tvColor;
    }
}
