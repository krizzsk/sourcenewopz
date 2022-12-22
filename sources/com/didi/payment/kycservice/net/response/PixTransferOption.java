package com.didi.payment.kycservice.net.response;

import com.didi.payment.commonsdk.net.WBaseResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixTransferOption;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "()V", "data", "Lcom/didi/payment/kycservice/net/response/PixTransferOption$TransferOptionInfo;", "getData", "()Lcom/didi/payment/kycservice/net/response/PixTransferOption$TransferOptionInfo;", "setData", "(Lcom/didi/payment/kycservice/net/response/PixTransferOption$TransferOptionInfo;)V", "TransferOptionInfo", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
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

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/response/PixTransferOption$TransferOptionInfo;", "", "()V", "userAvailableAmount", "", "getUserAvailableAmount", "()I", "setUserAvailableAmount", "(I)V", "userBlockAmount", "getUserBlockAmount", "setUserBlockAmount", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixTransferOption.kt */
    public static final class TransferOptionInfo {
        private int userAvailableAmount;
        private int userBlockAmount;

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
    }
}
