package com.didi.payment.transfer.fillamount;

import android.text.TextUtils;
import com.didi.payment.transfer.net.TransBaseResp;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TransCreateOrderResp extends TransBaseResp {
    @SerializedName("data")
    public DataBean data;

    public static class DataBean implements Serializable {
        @SerializedName("cashierType")
        public int cashierType;
        @SerializedName("noticePanelInfo")
        public NoticeInfo noticeInfo;
        @SerializedName("orderId")
        public String orderId;
        @SerializedName("outTradeId")
        public String outTradeId;
        @SerializedName("paymentPasswordInfo")
        public PaymentPasswordInfo paymentPasswordInfo;
        @SerializedName("toastInfo")
        public ToastInfo toastInfo;
    }

    public static class NoticeInfo implements Serializable {
        @SerializedName("cancelButton")
        public String cancelButton;
        @SerializedName("confirmButton")
        public String confirmButton;
        @SerializedName("content")
        public String content;
        @SerializedName("title")
        public String title;
    }

    public static class PaymentPasswordInfo implements Serializable {
        @SerializedName("paySessionId")
        public String paySessionId;
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
