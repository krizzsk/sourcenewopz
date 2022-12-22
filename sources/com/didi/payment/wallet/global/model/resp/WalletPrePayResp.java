package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.base.service.IWalletService;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WalletPrePayResp extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class DataBean implements Serializable {
        @SerializedName("extraInfo")
        public PayMethodSelectExtraInfo extraInfo;
        @SerializedName("limitRiskReminder")
        public LimitRiskReminderVo limitRiskReminder;
        @SerializedName("orderId")
        public String orderId;
        @SerializedName("outTradeId")
        public String outTradeId;
    }

    public static class PayMethodSelectExtraInfo implements Serializable {
        @SerializedName("accountStatusDetail")
        public IWalletService.AccountInfo accountInfo;
        public int accountStatus;
        @SerializedName("payMethodSelectionDialog")
        public PrePayDialogInfo prePayDialogInfo;
    }

    public static class PrePayDialogInfo implements Serializable {
        @SerializedName("allowUserOtherPayMethod")
        public boolean canUseOtherPay;
        @SerializedName("secondBtnText")
        public String negBtnText;
        @SerializedName("newSecondBtnText")
        public String newNegBtnText;
        @SerializedName("newFirstBtnText")
        public String newPosBtnText;
        @SerializedName("newTitle")
        public String newTitle;
        @SerializedName("firstBtnText")
        public String posBtnText;
        public String subTitle;
        public String title;
    }
}
