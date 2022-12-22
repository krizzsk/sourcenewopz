package com.didi.payment.pix.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixTransferOption;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "getData", "()Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "setData", "(Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;)V", "TransferOptionInfo", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferOption.kt */
public final class PixTransferOption extends WBaseResp {
    public TransferOptionInfo data;

    public final TransferOptionInfo getData() {
        TransferOptionInfo transferOptionInfo = this.data;
        if (transferOptionInfo != null) {
            return transferOptionInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setData(TransferOptionInfo transferOptionInfo) {
        Intrinsics.checkNotNullParameter(transferOptionInfo, "<set-?>");
        this.data = transferOptionInfo;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "", "()V", "isSameCpf", "", "()Ljava/lang/Boolean;", "setSameCpf", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "unableAmountBtnLabel", "", "getUnableAmountBtnLabel", "()Ljava/lang/String;", "setUnableAmountBtnLabel", "(Ljava/lang/String;)V", "unableAmountDesc", "getUnableAmountDesc", "setUnableAmountDesc", "unableAmountLabel", "getUnableAmountLabel", "setUnableAmountLabel", "userAvailableAmount", "", "getUserAvailableAmount", "()I", "setUserAvailableAmount", "(I)V", "userBlockAmount", "getUserBlockAmount", "setUserBlockAmount", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixTransferOption.kt */
    public static final class TransferOptionInfo {
        private Boolean isSameCpf = false;
        @SerializedName("unableAmountBtnLabel")
        private String unableAmountBtnLabel;
        @SerializedName("unableAmountDesc")
        private String unableAmountDesc;
        @SerializedName("unableAmountLabel")
        private String unableAmountLabel;
        private int userAvailableAmount;
        private int userBlockAmount;

        public final Boolean isSameCpf() {
            return this.isSameCpf;
        }

        public final void setSameCpf(Boolean bool) {
            this.isSameCpf = bool;
        }

        public final int getUserAvailableAmount() {
            return this.userAvailableAmount;
        }

        public final void setUserAvailableAmount(int i) {
            this.userAvailableAmount = i;
        }

        public final int getUserBlockAmount() {
            return this.userBlockAmount;
        }

        public final void setUserBlockAmount(int i) {
            this.userBlockAmount = i;
        }

        public final String getUnableAmountLabel() {
            return this.unableAmountLabel;
        }

        public final void setUnableAmountLabel(String str) {
            this.unableAmountLabel = str;
        }

        public final String getUnableAmountBtnLabel() {
            return this.unableAmountBtnLabel;
        }

        public final void setUnableAmountBtnLabel(String str) {
            this.unableAmountBtnLabel = str;
        }

        public final String getUnableAmountDesc() {
            return this.unableAmountDesc;
        }

        public final void setUnableAmountDesc(String str) {
            this.unableAmountDesc = str;
        }
    }
}
