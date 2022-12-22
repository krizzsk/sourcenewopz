package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.base.finResource.CommonResourceState;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationSection;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WalletPayResultResp extends WBaseResp {
    public static final int PAY_STATUS_FAILED = 2;
    public static final int PAY_STATUS_SUCCESS = 1;
    public static final int PAY_STATUS_WAITING = 0;
    public static final int PAY_STATUS_WAITING_FOR_SEND_TO_DRIVER = 99;
    public static final int STATUS_UNPAID = 6;
    public static final int TOPUP_ORDER_STATUS_COMPLETE = 4;
    public static final int TOPUP_ORDER_STATUS_FAILED = 5;
    public PayResultData data;

    public static class ItemModel implements Serializable {
        @SerializedName("color")
        public String color;
        public boolean isBold;
        public String title;
        public String value;
    }

    public static class PayResultData implements Serializable {
        public String amount;
        public String cancelSubTitle;
        public String cancelTitle;
        @SerializedName("commonResourceState")
        public CommonResourceState commonResourceState;
        public String currencySymbol;
        @SerializedName("expirationReminder")
        public List<String> expirationReminder;
        @SerializedName("hasBoletoInstallment")
        public int hasBoletoInstallment;
        @SerializedName("panelSection")
        public WalletOperationSection operationSection;
        @SerializedName("outTradeId")
        public String outTradeId;
        @SerializedName("payResult")
        public TopupResult payResult;
        public List<ItemModel> payeeStatement;
        public String payeeStatementTitle;
        public PopInfo pop;
        public List<ItemModel> rechargeStatement;
        @SerializedName("rechargeStatementTitle")
        public String rechargeStatementTile;
        public String remarkText;
        @SerializedName("title")
        public String resultMainTitle;
        @SerializedName("subTitle")
        public String resultSubTitle;
        @SerializedName("ruleLimitDetail")
        public RuleLimitDetailVo ruleLimitDetail;
        public boolean share;
        public String shareBannerText;
        public List<ItemModel> statement;
        public List<ItemModel> statementExtend;
        public int status;
        @SerializedName("subTitleBgColor")
        public String subTitleBgColor;
        @SerializedName("subTitleColor")
        public String subTitleColor;
        public int tripStatus;
    }

    public static class PopInfo implements Serializable {
        public String cancelButton;
        public String confirmButton;
        public List<PayRichInfo> items;
        public String pictureUrl;
        public String subTitle;
        public String title;
        public String type;
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
}
