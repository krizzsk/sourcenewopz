package com.didi.consume.phone.model;

import android.text.TextUtils;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CsCreateOrderResp extends WBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class DataBean implements Serializable {
        @SerializedName("cashierType")
        public int cashierType;
        @SerializedName("extraInfo")
        public PayMethodSelectExtraInfo extraInfo;
        @SerializedName("orderId")
        public String orderId;
        @SerializedName("outTradeId")
        public String outTradeId;
        @SerializedName("toastInfo")
        public ToastInfo toastInfo;
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

    public static class ToastInfo implements Serializable {
        @SerializedName("message")
        public String message;
        @SerializedName("type")
        public String type;

        public boolean isErrorToast() {
            return "error".equals(this.type) && !TextUtils.isEmpty(this.message);
        }
    }
}
