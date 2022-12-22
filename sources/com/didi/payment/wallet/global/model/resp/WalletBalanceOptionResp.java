package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOptionResp;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "data", "Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOptionList;", "(Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOptionList;)V", "getData", "()Lcom/didi/payment/wallet/global/model/resp/WalletBalanceOptionList;", "setData", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletBalanceOptionResp.kt */
public final class WalletBalanceOptionResp extends WBaseResp {
    @SerializedName("data")
    private WalletBalanceOptionList data;

    public WalletBalanceOptionResp() {
        this((WalletBalanceOptionList) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WalletBalanceOptionResp copy$default(WalletBalanceOptionResp walletBalanceOptionResp, WalletBalanceOptionList walletBalanceOptionList, int i, Object obj) {
        if ((i & 1) != 0) {
            walletBalanceOptionList = walletBalanceOptionResp.data;
        }
        return walletBalanceOptionResp.copy(walletBalanceOptionList);
    }

    public final WalletBalanceOptionList component1() {
        return this.data;
    }

    public final WalletBalanceOptionResp copy(WalletBalanceOptionList walletBalanceOptionList) {
        return new WalletBalanceOptionResp(walletBalanceOptionList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletBalanceOptionResp) && Intrinsics.areEqual((Object) this.data, (Object) ((WalletBalanceOptionResp) obj).data);
    }

    public int hashCode() {
        WalletBalanceOptionList walletBalanceOptionList = this.data;
        if (walletBalanceOptionList == null) {
            return 0;
        }
        return walletBalanceOptionList.hashCode();
    }

    public String toString() {
        return "WalletBalanceOptionResp(data=" + this.data + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletBalanceOptionResp(WalletBalanceOptionList walletBalanceOptionList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : walletBalanceOptionList);
    }

    public final WalletBalanceOptionList getData() {
        return this.data;
    }

    public final void setData(WalletBalanceOptionList walletBalanceOptionList) {
        this.data = walletBalanceOptionList;
    }

    public WalletBalanceOptionResp(WalletBalanceOptionList walletBalanceOptionList) {
        this.data = walletBalanceOptionList;
    }
}
