package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp$Data;", "getData", "()Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp$Data;", "setData", "(Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp$Data;)V", "Data", "Info", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletPopUpWindowResp.kt */
public final class WalletPopUpWindowResp extends WBaseResp {
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006%"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp$Data;", "", "()V", "buttonText", "", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "negativeButtonText", "getNegativeButtonText", "setNegativeButtonText", "pictureUrl", "getPictureUrl", "setPictureUrl", "rewardMessage", "Lcom/didi/payment/base/view/PayRichInfo;", "getRewardMessage", "()Lcom/didi/payment/base/view/PayRichInfo;", "setRewardMessage", "(Lcom/didi/payment/base/view/PayRichInfo;)V", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletPopUpWindowResp.kt */
    public static final class Data {
        @SerializedName("buttonText")
        private String buttonText = "";
        private String linkUrl;
        @SerializedName("cancelButtonText")
        private String negativeButtonText;
        @SerializedName("pictureUrl")
        private String pictureUrl = "";
        @SerializedName("rewardMessage")
        private PayRichInfo rewardMessage;
        @SerializedName("subTitle")
        private String subTitle = "";
        @SerializedName("title")
        private String title;
        @SerializedName("type")
        private Integer type;

        public final PayRichInfo getRewardMessage() {
            return this.rewardMessage;
        }

        public final void setRewardMessage(PayRichInfo payRichInfo) {
            this.rewardMessage = payRichInfo;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final void setSubTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subTitle = str;
        }

        public final String getButtonText() {
            return this.buttonText;
        }

        public final void setButtonText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.buttonText = str;
        }

        public final String getNegativeButtonText() {
            return this.negativeButtonText;
        }

        public final void setNegativeButtonText(String str) {
            this.negativeButtonText = str;
        }

        public final String getPictureUrl() {
            return this.pictureUrl;
        }

        public final void setPictureUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pictureUrl = str;
        }

        public final Integer getType() {
            return this.type;
        }

        public final void setType(Integer num) {
            this.type = num;
        }

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final void setLinkUrl(String str) {
            this.linkUrl = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp$Info;", "", "()V", "bold", "", "getBold", "()I", "setBold", "(I)V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "fontSize", "getFontSize", "setFontSize", "length", "getLength", "setLength", "start", "getStart", "setStart", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletPopUpWindowResp.kt */
    public static final class Info {
        private int bold;
        private String color = "";
        @SerializedName("font_size")
        private int fontSize;
        private int length;
        private int start;

        public final int getStart() {
            return this.start;
        }

        public final void setStart(int i) {
            this.start = i;
        }

        public final int getLength() {
            return this.length;
        }

        public final void setLength(int i) {
            this.length = i;
        }

        public final String getColor() {
            return this.color;
        }

        public final void setColor(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.color = str;
        }

        public final int getFontSize() {
            return this.fontSize;
        }

        public final void setFontSize(int i) {
            this.fontSize = i;
        }

        public final int getBold() {
            return this.bold;
        }

        public final void setBold(int i) {
            this.bold = i;
        }
    }
}
